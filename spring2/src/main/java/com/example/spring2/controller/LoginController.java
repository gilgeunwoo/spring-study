package com.example.spring2.controller;

import com.example.spring2.payload.request.LoginRequest;
import com.example.spring2.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public void logIn(@RequestBody LoginRequest loginRequest) {
        loginService.logIn(loginRequest);
    }
}
