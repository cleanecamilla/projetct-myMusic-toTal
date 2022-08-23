package com.ciandt.summit.bootcamp2022.domains.token.exceptions;

public class BadAuthRequestException extends RuntimeException {
    public BadAuthRequestException(String message) {
        super(message);
    }

    public BadAuthRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
