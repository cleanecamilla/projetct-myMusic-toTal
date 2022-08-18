package com.ciandt.summit.bootcamp2022.domain;

import com.ciandt.summit.bootcamp2022.domain.dtos.ArtistDTO;

public class Artist {

    private String id;
    private String name;

    public Artist() {}

    public Artist(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist(ArtistDTO artistDTO) {
        this.id = artistDTO.getId();
        this.name = artistDTO.getName();
    }

    public String  getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistDTO toArtistDTO() {
        return new ArtistDTO(this.id, this.name);
    }
}
