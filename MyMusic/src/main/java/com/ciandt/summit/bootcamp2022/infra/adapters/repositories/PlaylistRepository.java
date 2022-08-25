package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.domain.ports.repositories.PlaylistRepositoryPort;

public class PlaylistRepository implements PlaylistRepositoryPort {

    private final SpringPlaylistRepository springPlaylistRepository;

    public PlaylistRepository(SpringPlaylistRepository springPlaylistRepository) {
        this.springPlaylistRepository = springPlaylistRepository;
    }

    // override interface methods
}
