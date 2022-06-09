package com.example.springsignup.dto.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Response {

    private final String accountId;
    private final String password;
    private final String name;
    private final String number;
}
