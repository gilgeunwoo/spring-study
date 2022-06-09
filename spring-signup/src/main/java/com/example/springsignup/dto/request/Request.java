package com.example.springsignup.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class Request {

    @NotBlank(message = "id에는 공백이 없어야 한다.")
    private String accountId;

    @NotBlank(message = "password에는 공백이 없어야 한다.")
    private String password;

    private String name;
    private String number;
}
