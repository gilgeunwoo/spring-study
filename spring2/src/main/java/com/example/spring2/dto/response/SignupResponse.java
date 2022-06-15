package com.example.spring2.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SignupResponse {

    private String email;
    private String password;
}
