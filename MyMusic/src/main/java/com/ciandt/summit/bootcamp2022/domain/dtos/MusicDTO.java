package com.ciandt.summit.bootcamp2022.domain.dtos;

import java.io.Serializable;

public class MusicDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private String  id;
    private String name;
    private String artistId;

    public MusicDTO(String id, String name, String artistId) {
        this.id = id;
        this.name = name;
        this.artistId = artistId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtistId() {
        return artistId;
    }
}
