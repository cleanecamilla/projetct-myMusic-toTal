package com.ciandt.summit.bootcamp2022.domain.dtos;

import java.io.Serializable;
import java.util.UUID;

public class ArtistDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private UUID id;
    private String name;

    public ArtistDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
