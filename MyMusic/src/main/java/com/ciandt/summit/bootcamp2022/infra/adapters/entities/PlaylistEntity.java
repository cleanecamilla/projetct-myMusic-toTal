package com.ciandt.summit.bootcamp2022.infra.adapters.entities;

import com.ciandt.summit.bootcamp2022.domain.Music;
import com.ciandt.summit.bootcamp2022.domain.Playlist;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private List<MusicEntity> musics = new ArrayList<>();

    public PlaylistEntity() {}

    public PlaylistEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<MusicEntity> getMusics() {
        return musics;
    }
}
