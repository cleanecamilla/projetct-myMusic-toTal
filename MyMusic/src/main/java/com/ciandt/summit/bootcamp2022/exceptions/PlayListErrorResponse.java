package com.ciandt.summit.bootcamp2022.exceptions;

public class PlayListErrorResponse {
    int status;
    String message;

    public PlayListErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public PlayListErrorResponse() {
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