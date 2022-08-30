package com.ciandt.summit.bootcamp2022.domain.ports.repositories;

import com.ciandt.summit.bootcamp2022.domain.Music;
import com.ciandt.summit.bootcamp2022.domain.Playlist;

public interface PlaylistRepositoryPort {
    Playlist addMusicToPlaylist(String playlistId, Music music);
    void removeMusicFromPlaylist();

}
