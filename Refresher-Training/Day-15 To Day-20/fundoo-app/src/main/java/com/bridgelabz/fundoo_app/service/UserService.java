package com.bridgelabz.fundoo_app.service;

import com.bridgelabz.fundoo_app.dto.AuthResponse;
import com.bridgelabz.fundoo_app.dto.LoginRequest;
import com.bridgelabz.fundoo_app.dto.RegisterRequest;

public interface UserService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

    void resetPassword(String email);
}