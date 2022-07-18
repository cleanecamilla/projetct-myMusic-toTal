package com.ciandt.summit.bootcamp2022.exceptions;

public class UnauthorizedErrorResponse {

    int status;
    String message;

    public UnauthorizedErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
