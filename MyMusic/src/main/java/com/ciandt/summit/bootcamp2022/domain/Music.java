package com.ciandt.summit.bootcamp2022.domain;

import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;

import java.util.UUID;

public class Music {

    private UUID id;
    private String name;
    private UUID artistId;

    public Music() {}

    public Music(UUID id, String name, UUID artistId) {
        this.id = id;
        this.name = name;
        this.artistId = artistId;
    }

    public Music(MusicDTO musicDTO) {
        this.id = musicDTO.getId();
        this.name = musicDTO.getName();
        this.artistId = musicDTO.getArtistId();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UUID getArtistId() {
        return artistId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtistId(UUID artistId) {
        this.artistId = artistId;
    }

    public MusicDTO toMusicDTO() {
        return new MusicDTO(this.id, this.name, this.artistId);
    }
}
