package com.example.spring2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter  // 필드에 접근하게 해줌
@AllArgsConstructor
public class PostRequest {

    private String title;
    private String contents;
    private String a;
}
