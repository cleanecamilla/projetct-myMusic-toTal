package com.ciandt.summit.bootcamp2022.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Playlists")
public class Playlist {

    @Id
    private String id;

    @ManyToMany
    @JoinTable(name = "PlaylistMusicas",
            joinColumns = {@JoinColumn(name = "PlaylistId")},
            inverseJoinColumns = {@JoinColumn(name = "MusicasId")})
    private List<Musica> musicas = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
}
