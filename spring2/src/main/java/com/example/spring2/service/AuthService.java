package com.example.spring2.service;


import com.example.spring2.dto.request.LoginRequest;
import com.example.spring2.dto.request.SignupRequest;
import com.example.spring2.dto.response.TokenResponse;

public interface AuthService {
    void signup(SignupRequest signupRequest);

    TokenResponse signin(LoginRequest loginRequest);

    TokenResponse reissue(String token);
}
