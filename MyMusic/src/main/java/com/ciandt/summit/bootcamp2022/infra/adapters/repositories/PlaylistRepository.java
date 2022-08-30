package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.domain.Music;
import com.ciandt.summit.bootcamp2022.domain.Playlist;
import com.ciandt.summit.bootcamp2022.domain.ports.repositories.PlaylistRepositoryPort;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.MusicEntity;

public class PlaylistRepository implements PlaylistRepositoryPort {

    private final SpringPlaylistRepository springPlaylistRepository;

    public PlaylistRepository(SpringPlaylistRepository springPlaylistRepository) {
        this.springPlaylistRepository = springPlaylistRepository;
    }

    @Override
    public Playlist addMusicToPlaylist(String playlistId, Music music) {
        return null;
    }

    @Override
    public void removeMusicFromPlaylist() {

    }

    // override interface methods
}
