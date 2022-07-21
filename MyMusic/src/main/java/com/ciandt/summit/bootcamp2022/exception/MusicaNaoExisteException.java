package com.ciandt.summit.bootcamp2022.exception;

public class MusicaNaoExisteException extends RuntimeException{

    public MusicaNaoExisteException(String message){
        super(message);
    }
}
