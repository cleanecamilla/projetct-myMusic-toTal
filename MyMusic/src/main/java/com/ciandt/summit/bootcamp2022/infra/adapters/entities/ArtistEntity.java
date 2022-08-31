package com.ciandt.summit.bootcamp2022.infra.adapters.entities;

import com.ciandt.summit.bootcamp2022.domain.Artist;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Artistas")
public class ArtistEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="Id")
    private String id;
    @Column(name="Nome")
    private String name;

    @OneToMany(mappedBy = "artist")
    @JsonIgnore
    private List<MusicEntity> musics;


    public ArtistEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArtistEntity() {
    }

    public ArtistEntity(Artist artist) {
        this.id = artist.getId();
        this.name = artist.getName();
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

    public Artist toArtist() {
        return new Artist(this.id, this.name);
    }

}