package com.ciandt.summit.bootcamp2022.infra.adapters.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Artist")
public class ArtistEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="Id")
    private String id;
    @Column(name="Name")
    private String name;

    @OneToMany(mappedBy = "artist")
    private Set<MusicEntity> musics = new HashSet<>();

    public ArtistEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArtistEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public Set<MusicEntity> getMusics() {
        return musics;
    }
    public void setMusics(Set<MusicEntity> musics) {
        this.musics = musics;
    }
}