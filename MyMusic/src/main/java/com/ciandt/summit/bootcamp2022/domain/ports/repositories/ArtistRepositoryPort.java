package com.ciandt.summit.bootcamp2022.domain.ports.repositories;
import com.ciandt.summit.bootcamp2022.domain.Artist;
import java.util.Set;

public interface ArtistRepositoryPort {
    Set<Artist> getArtistByFilter();
}
