package com.ciandt.summit.bootcamp2022.domains.playlists.ports.repositories;

import com.ciandt.summit.bootcamp2022.infra.adapters.entities.PlaylistEntity;

import java.util.Optional;

public interface PlaylistRespositoryPort {
    Optional<PlaylistEntity> findById(String id);

    void addSong(PlaylistEntity playlistEntity);
}
