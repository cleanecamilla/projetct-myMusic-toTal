package com.ciandt.summit.bootcamp2022.exception;

public class UsuarioNaoAutorizadoException extends RuntimeException{

    public UsuarioNaoAutorizadoException(String message){
        super(message);
    }
}
