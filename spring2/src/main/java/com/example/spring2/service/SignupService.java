package com.example.spring2.service;


import com.example.spring2.entity.Member;
import com.example.spring2.entity.repository.MemberRepository;
import com.example.spring2.payload.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class SignupService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(SignupRequest signupRequest) {
        if (memberRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
            throw new RuntimeException();
        }

        Member member = Member.builder()
                .email(signupRequest.getEmail())
                .password(passwordEncoder.encode(signupRequest.getPassword()))
                .build();
        memberRepository.save(member);
    }



}
