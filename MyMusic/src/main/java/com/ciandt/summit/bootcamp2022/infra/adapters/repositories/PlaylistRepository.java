package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.domain.Music;
import com.ciandt.summit.bootcamp2022.domain.ports.repositories.PlaylistRepositoryPort;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.MusicEntity;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.PlaylistEntity;
import org.springframework.stereotype.Component;

@Component
public class PlaylistRepository implements PlaylistRepositoryPort {

    private final SpringPlaylistRepository springPlaylistRepository;

    public PlaylistRepository(SpringPlaylistRepository springPlaylistRepository) {
        this.springPlaylistRepository = springPlaylistRepository;
    }

    @Override
    public void addMusicToPlaylist(String playlistId, Music music) {
        PlaylistEntity playlistEntity = this.springPlaylistRepository.getById(playlistId);
        playlistEntity.getMusics().add(new MusicEntity(music));
        this.springPlaylistRepository.save(playlistEntity);
    }

    @Override
    public void removeMusicFromPlaylist() {

    }

}
