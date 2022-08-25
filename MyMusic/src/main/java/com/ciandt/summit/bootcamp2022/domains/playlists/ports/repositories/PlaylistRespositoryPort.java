package com.ciandt.summit.bootcamp2022.domains.playlists.ports.repositories;

import com.ciandt.summit.bootcamp2022.domains.exceptions.playlists.PlaylistsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.playlists.Playlist;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.PlaylistEntity;

public interface PlaylistRespositoryPort {
    Playlist findById(String id) throws PlaylistsNotFoundException;

    void addSong(PlaylistEntity playlistEntity);
}
