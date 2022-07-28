package com.ciandt.summit.bootcamp2022.common.exception.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class CredentialsException extends Exception {

    public CredentialsException(String message) {
        super(message);
    }
    
}
