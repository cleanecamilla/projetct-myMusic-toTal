package com.ciandt.summit.bootcamp2022.domain;

import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.PlaylistEntity;

import java.util.ArrayList;
import java.util.List;

public class Music {

    private String  id;
    private String name;

    private Artist artist;
    private List<PlaylistEntity> playlists = new ArrayList<>();

    public Music() {}

    public Music(String  id, String name, Artist artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

    public Music(MusicDTO musicDTO) {
        this.id = musicDTO.getId();
        this.name = musicDTO.getName();
        this.artist = new Artist(musicDTO.getArtist());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlaylistEntity> getPlaylists() {
        return playlists;
    }

    public MusicDTO toMusicDTO() {
        return new MusicDTO(this.id, this.name, this.getArtist().toArtistDTO());
    }
}
