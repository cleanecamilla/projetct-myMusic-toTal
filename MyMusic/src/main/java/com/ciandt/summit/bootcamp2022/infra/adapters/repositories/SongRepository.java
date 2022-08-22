package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.repositories.SongRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SongRepository implements SongRepositoryPort {
    @Autowired
    private SpringSongRepository songRepository;

    @Override
    public List<Song> findByNameOrArtistName(String name, int pageNumber) {
        return null;
    }


}
