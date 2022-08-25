package com.ciandt.summit.bootcamp2022.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "INVALID USERNAME")
public class UserNotFoundException extends AuthenticationException {
    private static final String MSG = "User was not found";

    public UserNotFoundException() {
        super(MSG);
    }
}
