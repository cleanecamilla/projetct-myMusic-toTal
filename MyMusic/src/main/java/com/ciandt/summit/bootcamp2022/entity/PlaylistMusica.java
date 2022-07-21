package com.ciandt.summit.bootcamp2022.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PlaylistMusicas")
public class PlaylistMusica {

    @EmbeddedId
    private PlaylistMusicaKey playlistMusicaKey;

    public PlaylistMusica() {
    }

    public PlaylistMusica(PlaylistMusicaKey playlistMusicaKey) {
        this.playlistMusicaKey = playlistMusicaKey;
    }

    public PlaylistMusicaKey getPlaylistMusicaKey() {
        return playlistMusicaKey;
    }

    public void setPlaylistMusicaKey(PlaylistMusicaKey playlistMusicaKey) {
        this.playlistMusicaKey = playlistMusicaKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaylistMusica that = (PlaylistMusica) o;

        return playlistMusicaKey != null ? playlistMusicaKey.equals(that.playlistMusicaKey) : that.playlistMusicaKey == null;
    }

    @Override
    public int hashCode() {
        return playlistMusicaKey != null ? playlistMusicaKey.hashCode() : 0;
    }
}
