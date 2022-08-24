package com.ciandt.summit.bootcamp2022.infra.adapters.entities;

import com.ciandt.summit.bootcamp2022.domains.playlists.Playlist;
import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistEntity {
    @Id
    @Column(name = "Id")
    private String id = UUID.randomUUID().toString();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "PlaylistMusicas",
            joinColumns = @JoinColumn(name = "PlaylistId", referencedColumnName = "Id"),
            inverseJoinColumns = @JoinColumn(name = "MusicaId", referencedColumnName = "Id")
    )
    public List<SongEntity> songs;

    public PlaylistEntity(Playlist playlist) {
        this.id = playlist.getId();
        this.songs = playlist.getSongs()
                .stream()
                .map(SongEntity::new)
                .collect(Collectors.toList());
    }

    public Playlist toPlaylist() {
        List<Song> songsMapped = this.songs.stream().map(SongEntity::toSong).collect(Collectors.toList());

        return new Playlist(this.id, songsMapped);
    }
}


