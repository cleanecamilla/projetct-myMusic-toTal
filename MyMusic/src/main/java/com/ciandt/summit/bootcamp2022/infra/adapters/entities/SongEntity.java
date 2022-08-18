package com.ciandt.summit.bootcamp2022.infra.adapters.entities;

import com.ciandt.summit.bootcamp2022.domains.songs.Song;

import javax.persistence.*;

@Entity
@Table(name = "Musicas")
public class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "Nome")
    private String name;

    @Column(name = "ArtistaId")
    private String artistId;

    public SongEntity() {
    }

    public SongEntity(String id, String name, String artistId) {
        this.id = id;
        this.name = name;
        this.artistId = artistId;
    }

    public Song toSong() {
        return new Song(this.id, this.name, this.artistId);
    }
}
