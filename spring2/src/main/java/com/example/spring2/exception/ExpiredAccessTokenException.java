package com.example.spring2.exception;

public class ExpiredAccessTokenException extends BusinessException {

    public static BusinessException EXCEPTION =
            new ExpiredAccessTokenException();

    private ExpiredAccessTokenException() {
        super(ErrorCode.EXPIRED_ACCESS_TOKEN);
    }
}
