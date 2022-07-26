package com.ciandt.summit.bootcamp2022.exception;

public class PlaylistNaoContemMusicaException extends RuntimeException{

    public PlaylistNaoContemMusicaException(String message){
        super(message);
    }
}
