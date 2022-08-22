package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.repositories.SongRepositoryPort;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.SongEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SongRepository implements SongRepositoryPort {
    @Autowired
    private SpringSongRepository songRepository;

    @Override
    public List<Song> findByNameOrArtistName(String name, int pageNumber) {
        Pageable pageable = Pageable.ofSize(10).withPage(pageNumber);

        return songRepository.findByNameOrArtistName(name, pageable)
                .stream()
                .map(SongEntity::toSong)
                .collect(Collectors.toList());
    }
}
