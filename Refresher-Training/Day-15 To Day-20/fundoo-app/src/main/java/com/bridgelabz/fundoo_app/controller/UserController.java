package com.bridgelabz.fundoo_app.controller;

import com.bridgelabz.fundoo_app.dto.AuthResponse;
import com.bridgelabz.fundoo_app.dto.LoginRequest;
import com.bridgelabz.fundoo_app.dto.RegisterRequest;
import com.bridgelabz.fundoo_app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/userSignUp")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        AuthResponse response = userService.register(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody LoginRequest request) {

        AuthResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/reset")
    public ResponseEntity<String> reset(@RequestParam String email) {
        userService.resetPassword(email);
        return ResponseEntity.ok("Password reset link sent successfully");
    }
}