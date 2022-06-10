package com.example.spring2.controller;


import com.example.spring2.payload.request.SignupRequest;
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
public class SignUpController {

    private final SignupService signupService;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid SignupRequest signupRequest) {
        signupService.signUp(signupRequest);
    }
}
