package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.domain.Artist;
import com.ciandt.summit.bootcamp2022.domain.ports.repositories.ArtistRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ArtistRepository implements ArtistRepositoryPort {

    private final SpringArtistRepository springArtistRepository;

    public ArtistRepository(SpringArtistRepository springArtistRepository) {
        this.springArtistRepository = springArtistRepository;
    }

    @Override
    public Set<Artist> getArtistByFilter() {
        return null;
    }
}
