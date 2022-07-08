package com.example.spring2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RefreshToken {

    @Id
    private String username;
    private String refreshToken;
    private Long refreshTokenExpiration;

    public RefreshToken update(Long refreshExp) {
        this.refreshTokenExpiration = refreshExp;
        return this;
    }
}
