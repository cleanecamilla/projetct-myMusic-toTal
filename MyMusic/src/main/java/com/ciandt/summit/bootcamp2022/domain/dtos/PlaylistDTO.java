package com.ciandt.summit.bootcamp2022.domain.dtos;

import java.io.Serializable;

public class PlaylistDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;

    public PlaylistDTO() {}

    public PlaylistDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
