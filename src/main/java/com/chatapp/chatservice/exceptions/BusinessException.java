package com.chatapp.chatservice.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends BaseException{

    public BusinessException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    public BusinessException(String message, Integer errorCode) {
        super(message, errorCode);
    }
}
