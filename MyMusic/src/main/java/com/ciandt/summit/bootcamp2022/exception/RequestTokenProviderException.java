package com.ciandt.summit.bootcamp2022.exception;

public class RequestTokenProviderException extends Exception {

    public RequestTokenProviderException(String msg) {
        super(msg);
    }

    public RequestTokenProviderException(String msg, Throwable ex) {
        super(msg, ex);
    }
    
}
