package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.dto.MusicDTO;
import com.ciandt.summit.bootcamp2022.entity.Playlist;

public interface PlaylistService {
    Playlist addMusicToPlaylist(String id, MusicDTO musicDTO);
}
