package com.ciandt.summit.bootcamp2022.domains.artists.dtos;

import com.ciandt.summit.bootcamp2022.domains.songs.Song;

import java.util.List;

public class ArtistDTO {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistDTO(String id,String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
