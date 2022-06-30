package com.example.spring2.exception;

import com.example.spring2.entity.User;

public class UserNotFoundException extends BusinessException {

    public static BusinessException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}