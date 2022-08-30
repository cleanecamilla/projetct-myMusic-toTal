package com.ciandt.summit.bootcamp2022.domains.exceptions.songs;

public class DuplicatedSongInPlaylist extends Exception {
    public DuplicatedSongInPlaylist(String message) {
        super(message);
    }
}
