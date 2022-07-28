package com.ciandt.summit.bootcamp2022.common.exception.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class RequestTokenProviderApiException extends Exception {

    public RequestTokenProviderApiException(String msg) {
        super(msg);
    }

    public RequestTokenProviderApiException(String msg, Throwable ex) {
        super(msg, ex);
    }
    
}
