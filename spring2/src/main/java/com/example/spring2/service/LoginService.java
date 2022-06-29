package com.example.spring2.service;


import com.example.spring2.entity.User;
import com.example.spring2.entity.repository.UserRepository;
import com.example.spring2.dto.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final UserRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void logIn(LoginRequest loginRequest) {

        User member = memberRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(RuntimeException::new);

        if (!passwordEncoder.matches(loginRequest.getPassword(), member.getPassword())) {
            throw new RuntimeException();
        }



    }
}
