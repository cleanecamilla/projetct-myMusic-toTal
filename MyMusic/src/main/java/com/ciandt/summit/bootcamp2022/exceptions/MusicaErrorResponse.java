package com.ciandt.summit.bootcamp2022.exceptions;

public class MusicaErrorResponse {

    int status;
    String message;

    public MusicaErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public MusicaErrorResponse() {
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
