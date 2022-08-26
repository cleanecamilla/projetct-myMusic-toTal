package com.ciandt.summit.bootcamp2022.domains.songs.adapters.services;

import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.InvalidSongNameOrArtistNameException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.interfaces.SongServicePort;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.repositories.SongRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SongServiceImp implements SongServicePort {
    private final SongRepositoryPort songRepositoryPort;

    public SongServiceImp(SongRepositoryPort songRepositoryPort) {
        this.songRepositoryPort = songRepositoryPort;
    }

    @Override
    public List<SongDTO> findByNameOrArtistName(String name, int pageNumber)
            throws InvalidSongNameOrArtistNameException, SongsNotFoundException {

        if(name == null || name.isBlank() || name.length() < 2){
            throw new InvalidSongNameOrArtistNameException("Filter must be at least 2 characters long.");
        }

        List<Song> songs = songRepositoryPort.findByNameOrArtistName(name, pageNumber);
        return convertSongListToDTOList(songs);
    }

    private List<SongDTO> convertSongListToDTOList(List<Song> songs) throws SongsNotFoundException {
        if(songs.isEmpty()){
            throw new SongsNotFoundException("No songs were found.");
        }

        return songs.stream()
                .map(Song::toDTO)
                .collect(Collectors.toList());
    }
}