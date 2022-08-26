package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.domains.exceptions.playlists.PlaylistsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.playlists.Playlist;
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
    public Playlist findById(String id) throws PlaylistsNotFoundException {
        Optional<PlaylistEntity> playlistEntity = playlistRepository.findById(id);
        if (playlistEntity.isPresent()) {
            return playlistEntity.get().toPlaylist();
        } else {
            throw new PlaylistsNotFoundException("Specified playlist was not found");
        }
    }

    @Override
    public void addSong(PlaylistEntity playlistEntity) {
        playlistRepository.save(playlistEntity);
    }

}


