package com.ciandt.summit.bootcamp2022.domain.adapters.services;

import com.ciandt.summit.bootcamp2022.domain.Music;
import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import com.ciandt.summit.bootcamp2022.domain.ports.interfaces.PlaylistServicePort;
import com.ciandt.summit.bootcamp2022.domain.ports.repositories.PlaylistRepositoryPort;

public class PlaylistServiceImpl implements PlaylistServicePort {

    private final PlaylistRepositoryPort playlistRepositoryPort;

    public PlaylistServiceImpl(PlaylistRepositoryPort playlistRepositoryPort) {
        this.playlistRepositoryPort = playlistRepositoryPort;
    }

    @Override
    public void addMusicToPlaylist(String playlistId, MusicDTO musicDTO) {
        this.playlistRepositoryPort.addMusicToPlaylist(playlistId, new Music(musicDTO));
    }

    @Override
    public void removeMusicFromPlaylist(String playlistId, String musicId) {
        this.playlistRepositoryPort.removeMusicFromPlaylist(playlistId, musicId);
    }

}
