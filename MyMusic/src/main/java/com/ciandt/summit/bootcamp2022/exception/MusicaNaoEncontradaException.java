package com.ciandt.summit.bootcamp2022.exception;

public class MusicaNaoEncontradaException extends RuntimeException{

    public MusicaNaoEncontradaException(String message){
        super(message);
    }
}
