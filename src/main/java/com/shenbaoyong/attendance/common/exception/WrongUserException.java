package com.shenbaoyong.attendance.common.exception;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
public class WrongUserException extends RuntimeException{
    public WrongUserException() {
    }

    public WrongUserException(String message) {
        super(message);
    }

    public WrongUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongUserException(Throwable cause) {
        super(cause);
    }

    public WrongUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
