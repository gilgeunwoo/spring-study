package com.example.spring2.payload.request;


import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class LoginRequest {

    private String email;
    private String password;
}
