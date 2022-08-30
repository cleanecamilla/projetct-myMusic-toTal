package com.ciandt.summit.bootcamp2022.domain.dtos;

import com.ciandt.summit.bootcamp2022.domain.Music;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private List<Music> musics = new ArrayList<>();

    public PlaylistDTO() {}

    public PlaylistDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<Music> getMusics() {
        return musics;
    }
}
