package com.ciandt.summit.bootcamp2022.domain;

import com.ciandt.summit.bootcamp2022.domain.dtos.ArtistDTO;

import java.util.UUID;

public class Artist {

    private UUID id;
    private String name;

    public Artist() {}

    public Artist(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist(ArtistDTO artistDTO) {
        this.id = artistDTO.getId();
        this.name = artistDTO.getName();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistDTO toArtistDTO() {
        return new ArtistDTO(this.id, this.name);
    }
}
