package com.example.spring2.controller;

import com.example.spring2.dto.request.LoginRequest;
import com.example.spring2.dto.request.SignupRequest;
import com.example.spring2.service.LoginService;
import com.example.spring2.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class AuthController {

    private final LoginService loginService;
    private final SignupService signupService;
    @PostMapping("/login")
    public void logIn(@RequestBody LoginRequest loginRequest) {
        loginService.logIn(loginRequest);
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid SignupRequest signupRequest) {
        signupService.signUp(signupRequest);
    }
}
