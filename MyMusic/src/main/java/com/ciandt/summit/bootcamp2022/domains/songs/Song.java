package com.ciandt.summit.bootcamp2022.domains.songs;

import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;

import java.util.Objects;

public class Song {
    private String id;
    private String name;
    private String artistId;

    public Song() {
    }

    public Song(String id, String name, String artistId) {
        this.id = id;
        this.name = name;
        this.artistId = artistId;
    }

    public Song(SongDTO songDTO) {
        this.name = songDTO.getName();
        this.artistId = songDTO.getArtistId();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtistId() {
        return artistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(name, song.name) && Objects.equals(artistId, song.artistId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, artistId);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", artistId='" + artistId + '\'' +
                '}';
    }
}
