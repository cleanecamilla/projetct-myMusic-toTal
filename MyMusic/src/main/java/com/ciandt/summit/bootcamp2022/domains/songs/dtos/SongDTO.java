package com.ciandt.summit.bootcamp2022.domains.songs.dtos;

import java.util.Objects;

public class SongDTO {

    private String name;
    private String artistId;

    public SongDTO(String name, String artistId) {
        this.name = name;
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public String getArtistId() {
        return artistId;
    }
}
