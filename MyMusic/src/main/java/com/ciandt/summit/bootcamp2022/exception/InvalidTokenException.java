package com.ciandt.summit.bootcamp2022.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "INVALID TOKEN")
public class InvalidTokenException extends BadCredentialsException {
    static final String MSG = "Invalid or expired token";
    public InvalidTokenException() {
        super(MSG);
    }
}
