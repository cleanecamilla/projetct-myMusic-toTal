package com.ciandt.summit.bootcamp2022.domains.songs.dtos;

import com.ciandt.summit.bootcamp2022.domains.artists.dtos.ArtistDTO;

public class SongDTO {

    private String id;
    private String name;
    private ArtistDTO artist;

    public SongDTO(String id, String name, ArtistDTO artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public ArtistDTO getArtist() {
        return artist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(ArtistDTO artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + '\"' +
                ",\"name\":\"" + name + '\"' +
                ",\"artist\":" + artist +
                '}';
    }
}
