package com.bridgelabz.fundoo_app.security;

import com.bridgelabz.fundoo_app.dto.UserPrincipal;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;

@Component
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Autowired(required = false)
    private RedisTemplate<String, Object> redisTemplate;

    public JwtAuthFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String token = authHeader.substring(7);

        // Use Case 9: Redis Token Caching
        Boolean isValid = null;
        String cacheKey = "jwt:valid:" + token;

        if (redisTemplate != null) {
            try {
                isValid = (Boolean) redisTemplate.opsForValue().get(cacheKey);
                if (isValid != null) {
                    log.info("JWT Validation Cache HIT for token");
                }
            } catch (Exception e) {
                log.warn("Redis connection failed for token cache check: {}", e.getMessage());
            }
        }

        if (isValid == null) {
            log.info("JWT Validation Cache MISS - validating token directly");
            isValid = jwtService.validateToken(token);

            if (isValid && redisTemplate != null) {
                try {
                    Date expiration = jwtService.getExpirationDateFromToken(token);
                    long ttlMs = expiration.getTime() - System.currentTimeMillis();
                    if (ttlMs > 0) {
                        redisTemplate.opsForValue().set(cacheKey, true, Duration.ofMillis(ttlMs));
                    }
                } catch (Exception e) {
                    log.warn("Failed to cache JWT validation status in Redis: {}", e.getMessage());
                }
            }
        }
        System.out.println("JWT VALID: " + isValid);
        if (isValid && SecurityContextHolder.getContext().getAuthentication() == null) {

            try {
                String email = jwtService.getEmailFromToken(token);
                Integer userId = jwtService.getUserIdFromToken(token);

                UserPrincipal principal = new UserPrincipal(userId, email);
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        principal, null, Collections.emptyList()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } catch (Exception e) {
                log.error("Failed to set user authentication in SecurityContext: {}", e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }
}
