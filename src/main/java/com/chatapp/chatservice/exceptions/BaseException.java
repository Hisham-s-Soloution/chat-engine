package com.chatapp.chatservice.exceptions;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final Integer errorCode;

    public BaseException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
