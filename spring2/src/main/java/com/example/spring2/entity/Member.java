package com.example.spring2.entity;


import lombok.*;

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
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

}