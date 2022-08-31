package com.ciandt.summit.bootcamp2022.domains.songs;

import com.ciandt.summit.bootcamp2022.domains.artists.Artist;
import com.ciandt.summit.bootcamp2022.domains.artists.dtos.ArtistDTO;
import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;

import java.util.Objects;

public class Song {
    private String id;
    private String name;
    private Artist artist;

    public Song() {
    }

    public Song(String id, String name, Artist artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        artist.getSongs().add(this);
    }

    public Song(SongDTO songDTO) {
        this.name = songDTO.getName();
        this.artist = songDTO.getArtist().toArtist();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Artist getArtistId() {
        return artist;
    } //TODO: refatorar

    public SongDTO toDTO(){
        ArtistDTO artistDTO = artist.toArtistDTO();
        return new SongDTO(this.getId(), this.getName(), artistDTO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(name, song.name) && Objects.equals(artist, song.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, artist);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", artistId='" + artist + '\'' +
                '}';
    }
}
