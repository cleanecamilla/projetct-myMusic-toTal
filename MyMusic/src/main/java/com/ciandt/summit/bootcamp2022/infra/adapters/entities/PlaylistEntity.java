package com.ciandt.summit.bootcamp2022.infra.adapters.entities;

import com.ciandt.summit.bootcamp2022.domain.Music;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Playlists")
public class PlaylistEntity {
    @Id
    @Column(name="Id")
    private String id;

    @ManyToMany
    @JoinTable(
            name = "PlaylistMusicas",
            joinColumns = @JoinColumn(name = "PlaylistId"),
            inverseJoinColumns = @JoinColumn(name = "MusicaId")
    )
    private List<Music> musics = new ArrayList<>();

    public PlaylistEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<Music> getMusics() {
        return musics;
    }
}
