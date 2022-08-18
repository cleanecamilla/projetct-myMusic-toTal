package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.domains.songs.ports.repositories.SongRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SongRepository implements SongRepositoryPort {
    @Autowired
    private SpringSongRepository songRepository;
}
