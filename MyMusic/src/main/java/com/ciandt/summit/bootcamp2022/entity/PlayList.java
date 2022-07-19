package com.ciandt.summit.bootcamp2022.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Playlists")
public class PlayList {

    @Id
    private final String id = UUID.randomUUID().toString();
    @OneToMany
    @JoinTable(name = "PlaylistMusicas", joinColumns = @JoinColumn(name = "PlaylistId"), inverseJoinColumns = @JoinColumn(name = "MusicaId"))
    private List<Musica> musicas;

    public PlayList(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public PlayList() {
    }

    public String getId() {
        return id;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
}
