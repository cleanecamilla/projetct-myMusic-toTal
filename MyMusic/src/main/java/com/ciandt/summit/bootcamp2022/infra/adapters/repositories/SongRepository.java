package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import com.ciandt.summit.bootcamp2022.domains.songs.SongsPaginated;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.repositories.SongRepositoryPort;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.SongEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SongRepository implements SongRepositoryPort {
    @Autowired
    private SpringSongRepository songRepository;

    @Override
    public Song findById(String id) throws SongsNotFoundException {
        Optional<SongEntity> songEntity = this.songRepository.findById(id);
        if (songEntity.isPresent()) {
            return songEntity.get().toSong();
        } else {
            throw new SongsNotFoundException("Specified song was not found.");
        }
    }

    @Override
    public SongsPaginated findByNameOrArtistName(String name, int pageNumber) {
        Pageable pageable = Pageable.ofSize(10).withPage(pageNumber);
        Page<SongEntity> page = songRepository.findByNameOrArtistName(name, pageable);

        List<Song> songList = page.stream()
                .map(SongEntity::toSong)
                .collect(Collectors.toList());

        return new SongsPaginated(songList, page.getTotalElements());
    }
}
