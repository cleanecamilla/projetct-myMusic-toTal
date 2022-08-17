package com.ciandt.summit.bootcamp2022.domain.dtos;

import java.io.Serializable;
import java.util.UUID;

public class MusicDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private UUID artistId;

    public MusicDTO(UUID id, String name, UUID artistId) {
        this.id = id;
        this.name = name;
        this.artistId = artistId;
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
}
