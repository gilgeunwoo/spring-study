package com.example.spring2.entity;


import com.example.spring2.payload.request.SignupRequest;
import jdk.jfr.StackTrace;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.relation.Role;
import javax.persistence.*;

@Getter @Setter
@ToString
@Table(name = "member")
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Member {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String email;

    private String password;

}