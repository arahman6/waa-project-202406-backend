package com.example.ecommerce.service;

import com.example.ecommerce.entity.dto.request.LoginRequest;
import com.example.ecommerce.entity.dto.request.RefreshTokenRequest;
import com.example.ecommerce.entity.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
