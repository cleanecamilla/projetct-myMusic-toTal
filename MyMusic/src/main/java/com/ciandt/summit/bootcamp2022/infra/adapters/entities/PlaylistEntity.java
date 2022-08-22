package com.ciandt.summit.bootcamp2022.infra.adapters.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Playlists")
public class PlaylistEntity {
    @Id
    @Column(name="Id")
    private String id;

    public String getId() {
        return id;
    }
}
