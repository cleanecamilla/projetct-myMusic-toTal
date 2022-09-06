package com.ciandt.summit.bootcamp2022.domain.adapters.services;

import com.ciandt.summit.bootcamp2022.domain.Artist;
import com.ciandt.summit.bootcamp2022.domain.dtos.ArtistDTO;
import com.ciandt.summit.bootcamp2022.domain.ports.interfaces.ArtistServicePort;
import com.ciandt.summit.bootcamp2022.domain.ports.repositories.ArtistRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

public class ArtistServiceImpl implements ArtistServicePort {

    private final ArtistRepositoryPort artistRepositoryPort;

    public ArtistServiceImpl(ArtistRepositoryPort artistRepositoryPort) {
        this.artistRepositoryPort = artistRepositoryPort;
    }

    @Override
    public Set<ArtistDTO> searchArtist() {
        Set<Artist> artistList = this.artistRepositoryPort.getArtistByFilter();
        Set<ArtistDTO> artistDTOS = artistList.stream().map(Artist::toArtistDTO).collect(Collectors.toSet());
        return artistDTOS;
    }
}
