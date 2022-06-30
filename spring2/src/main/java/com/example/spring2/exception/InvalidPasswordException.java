package com.example.spring2.exception;

public class InvalidPasswordException extends BusinessException {

    public static BusinessException EXCEPTION =
            new InvalidPasswordException();

    private InvalidPasswordException() {
        super(ErrorCode.INVALID__PASSWORD);
    }
}
