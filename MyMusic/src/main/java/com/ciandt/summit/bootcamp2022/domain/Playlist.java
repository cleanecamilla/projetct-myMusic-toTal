package com.ciandt.summit.bootcamp2022.domain;

import com.ciandt.summit.bootcamp2022.domain.dtos.PlaylistDTO;

public class Playlist {

    private String id;

    public Playlist() {}

    public Playlist(PlaylistDTO playlistDTO) {
        this.id = playlistDTO.getId();
    }

    public String getId() {
        return id;
    }

    public PlaylistDTO toPlaylistDTO() {
        return new PlaylistDTO(this.id);
    }

}
