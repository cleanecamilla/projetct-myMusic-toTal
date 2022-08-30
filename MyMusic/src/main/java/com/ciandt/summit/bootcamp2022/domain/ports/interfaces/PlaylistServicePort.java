package com.ciandt.summit.bootcamp2022.domain.ports.interfaces;

import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import com.ciandt.summit.bootcamp2022.domain.dtos.PlaylistDTO;

public interface PlaylistServicePort {

    PlaylistDTO addMusicToPlaylist(String playlistId, MusicDTO musicDTO);
    void removeMusicFromPlaylist();

}
