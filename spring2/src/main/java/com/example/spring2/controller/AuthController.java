package com.example.spring2.controller;

import com.example.spring2.dto.request.LoginRequest;
import com.example.spring2.dto.request.SignupRequest;
import com.example.spring2.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class AuthController {

    private AuthService authService;
    @PostMapping("/login")
    public void logIn(@RequestBody LoginRequest loginRequest) {
        authService.signin(loginRequest);
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody SignupRequest signupRequest) {
        authService.signup(signupRequest);
    }
}
