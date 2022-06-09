package com.example.springsignup.service;


import com.example.springsignup.dto.request.Request;
import com.example.springsignup.entity.Entity;
import com.example.springsignup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(Request request) {
        if (repository.findByAccountId(request.getAccountId()).isPresent()) {
            throw new RuntimeException();
        }

        Entity entity = Entity.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .number(request.getNumber())
                .build();
        repository.save(entity);
    }
}
