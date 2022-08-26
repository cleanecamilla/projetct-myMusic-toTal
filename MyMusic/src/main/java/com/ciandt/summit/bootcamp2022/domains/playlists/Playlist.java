package com.ciandt.summit.bootcamp2022.domains.playlists;

import com.ciandt.summit.bootcamp2022.domains.songs.Song;

import java.util.List;
import java.util.Objects;

public class Playlist {
    private String id;
    private List<Song> songs;

    public Playlist(String id, List<Song> songs) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(id, playlist.id) && Objects.equals(songs, playlist.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, songs);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
