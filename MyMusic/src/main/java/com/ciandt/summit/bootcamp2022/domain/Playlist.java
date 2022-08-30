package com.ciandt.summit.bootcamp2022.domain;

import com.ciandt.summit.bootcamp2022.domain.dtos.PlaylistDTO;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private String id;
    private List<Music> musics = new ArrayList<>();

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
