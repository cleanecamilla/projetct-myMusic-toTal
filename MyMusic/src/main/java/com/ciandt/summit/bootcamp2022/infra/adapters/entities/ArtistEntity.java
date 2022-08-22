package com.ciandt.summit.bootcamp2022.infra.adapters.entities;

import com.ciandt.summit.bootcamp2022.domains.artists.Artist;
import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Artistas")
public class ArtistEntity {
    @Id
    @Column(name = "Id")
    private String id = UUID.randomUUID().toString();
    @Column(name = "Nome")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "artist")
    private List<Song> songs;
    public ArtistEntity(Artist artist) {
        this.id = artist.getId();
        this.name = artist.getName();
        this.songs = artist.getSongs();
    }

    public Artist toArtist() {
        return new Artist(this.id, this.name, this.songs);
    }
}