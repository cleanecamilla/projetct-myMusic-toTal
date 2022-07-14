package com.ciandt.summit.bootcamp2022.exception;

public class UserErrorResponse {
    private int status;
    private String message;

    public UserErrorResponse() {
    }

    public UserErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
