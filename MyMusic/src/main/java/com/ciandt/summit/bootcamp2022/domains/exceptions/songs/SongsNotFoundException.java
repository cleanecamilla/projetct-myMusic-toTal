package com.ciandt.summit.bootcamp2022.domains.exceptions.songs;

public class SongsNotFoundException extends Exception{
    public SongsNotFoundException(String message) {
        super(message);
    }
}
