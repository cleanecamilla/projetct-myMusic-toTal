package com.ciandt.summit.bootcamp2022.domain.dtos;

import java.io.Serializable;

public class ArtistDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public ArtistDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
