package com.ciandt.summit.bootcamp2022.domains.exceptions.songs;

public class InvalidSongNameOrArtistNameException extends Exception{
    public InvalidSongNameOrArtistNameException(String message) {
        super(message);
    }
}
