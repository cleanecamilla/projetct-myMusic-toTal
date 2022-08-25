package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.domains.playlists.ports.repositories.PlaylistRespositoryPort;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.PlaylistEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlaylistRespository implements PlaylistRespositoryPort {

    @Autowired
    private SpringPlaylistRepository playlistRepository;


    @Override
    public Optional<PlaylistEntity> findById(String id) {
        return playlistRepository.findById(id);
    }

    @Override
    public void addSong(PlaylistEntity playlistEntity) {
        playlistRepository.save(playlistEntity);
    }
}


