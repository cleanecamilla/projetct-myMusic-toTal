package com.ciandt.summit.bootcamp2022.infra.adapters.entities;

import com.ciandt.summit.bootcamp2022.domain.Music;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Musicas")
public class MusicEntity {
    @Id
    @Column(name="Id")
    private String id;
    @Column(name="Nome")
    private String nome;
    @ManyToMany(mappedBy = "musics")
    private List<PlaylistEntity> playlists = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="ArtistaId", referencedColumnName = "Id")
    private ArtistEntity artist;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MusicEntity(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public MusicEntity() {
    }

    public MusicEntity(Music music) {
        this.id = music.getId();
        this.nome = music.getName();
        this.artist = new ArtistEntity(music.getArtist());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Music toMusic() {
        return new Music(this.id, this.nome);
    }

    public List<PlaylistEntity> getPlaylists() {
        return playlists;
    }

    public ArtistEntity getArtist() {
        return artist;
    }
}
