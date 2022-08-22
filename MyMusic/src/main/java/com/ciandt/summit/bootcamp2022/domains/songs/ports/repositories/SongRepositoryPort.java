package com.ciandt.summit.bootcamp2022.domains.songs.ports.repositories;

import com.ciandt.summit.bootcamp2022.domains.songs.Song;

import java.util.List;

public interface SongRepositoryPort {
    List<Song> findByNameOrArtistName(String name, int pageNumber);
}
