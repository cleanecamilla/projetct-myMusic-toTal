package com.ciandt.summit.bootcamp2022.domain.dtos;

import com.ciandt.summit.bootcamp2022.infra.adapters.entities.PlaylistEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MusicDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private String  id;
    private String name;

    private ArtistDTO artist;

    public MusicDTO(String id, String name, ArtistDTO artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArtistDTO getArtist() {
        return artist;
    }

}
