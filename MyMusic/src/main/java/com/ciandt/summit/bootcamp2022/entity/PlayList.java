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
    @JoinColumn(name = "PlaylistMusicas")
    private List<Musica> musica;

    public PlayList(List<Musica> musica) {
        this.musica = musica;
    }

    public String getId() {
        return id;
    }

    public List<Musica> getMusica() {
        return musica;
    }

    public void setMusica(List<Musica> musica) {
        this.musica = musica;
    }
}
