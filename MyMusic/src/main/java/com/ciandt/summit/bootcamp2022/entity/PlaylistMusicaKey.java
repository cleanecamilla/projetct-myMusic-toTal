package com.ciandt.summit.bootcamp2022.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PlaylistMusicaKey implements Serializable {

    @Column(name="PlaylistId")
    private String playlistId;
    @Column(name="MusicaId")
    private String musicaId;

    public PlaylistMusicaKey() {
    }

    public PlaylistMusicaKey(String playlistId, String musicaId) {
        this.playlistId = playlistId;
        this.musicaId = musicaId;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getMusicaId() {
        return musicaId;
    }

    public void setMusicaId(String musicaId) {
        this.musicaId = musicaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaylistMusicaKey that = (PlaylistMusicaKey) o;

        if (!playlistId.equals(that.playlistId)) return false;
        return musicaId.equals(that.musicaId);
    }

    @Override
    public int hashCode() {
        int result = playlistId.hashCode();
        result = 31 * result + musicaId.hashCode();
        return result;
    }
}
