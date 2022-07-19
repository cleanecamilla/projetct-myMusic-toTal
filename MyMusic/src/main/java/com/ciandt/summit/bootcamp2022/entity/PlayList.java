package com.ciandt.summit.bootcamp2022.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PlayLists")
public class PlayList {

    @Id
    private final String id = UUID.randomUUID().toString();
    @OneToMany
    @JoinColumn(name = "PlayListMusicas")
    private List<Musica> musicas;

    public PlayList(List<Musica> musicas) {
        this.musicas = musicas;
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
