package com.example.spring2.service;

import lombok.Value;

public class AuthServiceIpm implements AuthService{

    @Value("${jwt.exp.refresh}")
    private Long REFRESH_TOKEN_EXPIRATION_TIME;

    private final RefreshTokenRepository
}
