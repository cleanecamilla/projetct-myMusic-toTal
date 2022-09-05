package com.ciandt.summit.bootcamp2022.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User was not found")
public class UserNotFoundException extends AuthenticationException {
    private static final String MSG = "User was not found";

    public UserNotFoundException() {
        super(MSG);
    }
}
