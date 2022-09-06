package com.ciandt.summit.bootcamp2022.domain.ports.repositories;

import com.ciandt.summit.bootcamp2022.domain.Music;
import com.ciandt.summit.bootcamp2022.domain.Playlist;

public interface PlaylistRepositoryPort {
    void addMusicToPlaylist(String playlistId, Music music);
    void removeMusicFromPlaylist(String playlistId, String musicId);

}
