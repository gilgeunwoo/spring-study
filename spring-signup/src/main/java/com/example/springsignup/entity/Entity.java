package com.example.springsignup.entity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@javax.persistence.Entity
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 255, nullable = false)
    private String accountId;

    @Column(length = 16, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 4, nullable = false)
    private String number;

    @Builder
    public Entity(String accountId, String password, String name, String number) {
        this.accountId = accountId;
        this.name = name;
        this.number = number;
        this.password = password;
    }
}
