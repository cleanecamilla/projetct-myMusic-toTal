package com.ciandt.summit.bootcamp2022.domain.ports.interfaces;

import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import com.ciandt.summit.bootcamp2022.domain.dtos.PlaylistDTO;

public interface PlaylistServicePort {

    void addMusicToPlaylist(String playlistId, MusicDTO musicDTO);
    void removeMusicFromPlaylist(String playlistId, String musicId);


}
