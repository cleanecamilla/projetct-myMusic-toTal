package com.ciandt.summit.bootcamp2022.domains.playlists.ports.interfaces;

import com.ciandt.summit.bootcamp2022.domains.exceptions.playlists.PlaylistsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.DuplicatedSongInPlaylist;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.playlists.Playlist;
import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;

import java.util.List;

public interface PlaylistServicePort {
    Playlist addSongsToPlaylist(String id, List<SongDTO> songs) throws SongsNotFoundException, PlaylistsNotFoundException, DuplicatedSongInPlaylist;

    Playlist removeSongFromPlaylist(String id, String songId) throws SongsNotFoundException, PlaylistsNotFoundException;
}
