package com.example.spring2.jwt;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private String SECRET_KEY;

    @Value("${jwt.header}")
    private String HEADER;

    @Value("${jwt.prefix}")
    private String PREFIX;

    @Value("${jwt.exp.access}")
    private Long ACCESS_TOKEN_EXPIRATION_TIME;

    @Value("${jwt.exp.refresh}")
    private Long REFRESH_TOKEN_EXPIRATION_TIME;

    private

    @Value("${jwt.secret}")
    public void setSecretKey(String secretKey) {
        this.SECRET_KEY = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
    }


}