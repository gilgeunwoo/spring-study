package com.example.spring2.controller;

import com.example.spring2.dto.request.LoginRequest;
import com.example.spring2.dto.request.SignupRequest;
import com.example.spring2.service.LoginService;
import com.example.spring2.service.SecurityService;
import com.example.spring2.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;


@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class AuthController {

    private final LoginService loginService;
    private final SignupService signupService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/create/token")
    public Map<String, Object> createToken(@RequestParam(value = "subject") String subject) {
        String token = securityService.createToken(subject, (2*1000*60));
        Map<String,  Object> map =new LinkedHashMap<>();
        map.put("result" , token);
        return map;
    }

    @GetMapping("/get/subject")
    public Map<String, Object> getSubject(@RequestParam(value = "token") String token) {
        String subject = securityService.getSubject(token);
        Map<String,  Object> map =new LinkedHashMap<>();
        map.put("result" , subject);
        return map;
    }

    @PostMapping("/login")
    public void logIn(@RequestBody LoginRequest loginRequest) {
        loginService.logIn(loginRequest);
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid SignupRequest signupRequest) {
        signupService.signUp(signupRequest);
    }
}
