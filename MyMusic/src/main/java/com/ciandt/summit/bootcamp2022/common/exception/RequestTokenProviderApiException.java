package com.ciandt.summit.bootcamp2022.common.exception;

public class RequestTokenProviderApiException extends Exception {

    public RequestTokenProviderApiException(String msg) {
        super(msg);
    }

    public RequestTokenProviderApiException(String msg, Throwable ex) {
        super(msg, ex);
    }
    
}
