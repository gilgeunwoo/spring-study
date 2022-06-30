package com.example.spring2.exception;

public class ExpiredRefreshTokenException extends BusinessException {

    public static BusinessException EXCEPTION =
            new ExpiredRefreshTokenException();

    private ExpiredRefreshTokenException() {
        super(ErrorCode.EXPIRED_REFRESH_TOKEN);
    }
}
