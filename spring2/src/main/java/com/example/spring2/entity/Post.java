package com.example.spring2.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String contents;


    public Post update(String title, String contents) {
        this.title = title;
        this.contents = contents;

        return this;
    }
}
