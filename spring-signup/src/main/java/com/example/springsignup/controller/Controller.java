package com.example.springsignup.controller;


import com.example.springsignup.dto.request.Request;
import com.example.springsignup.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class Controller {

    private final Service service;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid Request request) {
        service.signUp(request);
    }
}
