package com.ciandt.summit.bootcamp2022.infra.adapters.entities;

import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Musicas")
public class SongEntity {

    @Id
    @Column(name = "Id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "Nome")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ArtistaId")
    private ArtistEntity artist;

    public SongEntity(Song song) {
        this.id = song.getId();
        this.name = song.getName();
        ArtistEntity artistEntity = new ArtistEntity(song.getArtistId());
        this.artist = artistEntity;
    }

    public Song toSong() {
        return new Song(this.id, this.name, this.artist.toArtist());
    }


}
