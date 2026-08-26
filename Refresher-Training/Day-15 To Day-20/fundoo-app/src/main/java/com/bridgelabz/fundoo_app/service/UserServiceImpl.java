package com.bridgelabz.fundoo_app.service;

import com.bridgelabz.fundoo_app.dto.AuthResponse;
import com.bridgelabz.fundoo_app.dto.LoginRequest;
import com.bridgelabz.fundoo_app.dto.RegisterRequest;
import com.bridgelabz.fundoo_app.entity.User;
import com.bridgelabz.fundoo_app.repository.UserRepository;
import com.bridgelabz.fundoo_app.security.JwtService;
import com.bridgelabz.fundoo_app.messaging.jms.ReminderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    
    @Autowired(required = false)
    private ReminderProducer reminderProducer;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .build();

        User savedUser = userRepository.save(user);
        String token = jwtService.generateToken(savedUser.getUserId(), savedUser.getEmail());
        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        String token = jwtService.generateToken(user.getUserId(), user.getEmail());
        return new AuthResponse(token);
    }

    @Override
    public void resetPassword(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Email not found"));

        // Use Case 8: Fire a JMS message for password recovery (best-effort)
        if (reminderProducer != null) {
            reminderProducer.sendPasswordReset(email);
        }
    }
}