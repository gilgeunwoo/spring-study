package com.example.spring2.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class LoginRequest {

    private String email;
    private String password;
    private String username;
}
