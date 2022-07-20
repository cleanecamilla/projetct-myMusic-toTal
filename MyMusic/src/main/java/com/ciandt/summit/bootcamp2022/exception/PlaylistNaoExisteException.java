package com.ciandt.summit.bootcamp2022.exception;

public class PlaylistNaoExisteException extends RuntimeException{

    public PlaylistNaoExisteException(String message){
        super(message);
    }
}
