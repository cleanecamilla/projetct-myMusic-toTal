package com.ciandt.summit.bootcamp2022.domains.songs.ports.repositories;

import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import com.ciandt.summit.bootcamp2022.domains.songs.SongsPaginated;

public interface SongRepositoryPort {
    Song findById(String id) throws SongsNotFoundException;
    SongsPaginated findByNameOrArtistName(String name, int pageNumber);
}
