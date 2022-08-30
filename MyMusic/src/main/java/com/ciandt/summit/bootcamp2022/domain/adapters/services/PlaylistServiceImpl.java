package com.ciandt.summit.bootcamp2022.domain.adapters.services;

import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import com.ciandt.summit.bootcamp2022.domain.dtos.PlaylistDTO;
import com.ciandt.summit.bootcamp2022.domain.ports.interfaces.PlaylistServicePort;
import com.ciandt.summit.bootcamp2022.domain.ports.repositories.PlaylistRepositoryPort;

public class PlaylistServiceImpl implements PlaylistServicePort {

    private final PlaylistRepositoryPort playlistRepositoryPort;

    public PlaylistServiceImpl(PlaylistRepositoryPort playlistRepositoryPort) {
        this.playlistRepositoryPort = playlistRepositoryPort;
    }

    @Override
    public PlaylistDTO addMusicToPlaylist(String playlistId, MusicDTO musicDTO) {
        return null;
    }

    @Override
    public void removeMusicFromPlaylist() {

    }
}
