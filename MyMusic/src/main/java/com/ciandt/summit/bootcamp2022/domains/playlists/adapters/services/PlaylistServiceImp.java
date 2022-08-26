package com.ciandt.summit.bootcamp2022.domains.playlists.adapters.services;

import com.ciandt.summit.bootcamp2022.domains.exceptions.playlists.PlaylistsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.playlists.Playlist;
import com.ciandt.summit.bootcamp2022.domains.playlists.ports.interfaces.PlaylistServicePort;
import com.ciandt.summit.bootcamp2022.domains.playlists.ports.repositories.PlaylistRespositoryPort;
import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.repositories.SongRepositoryPort;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.PlaylistEntity;

import java.util.List;

public class PlaylistServiceImp implements PlaylistServicePort {

    private final PlaylistRespositoryPort playlistRespositoryPort;
    private final SongRepositoryPort songRepositoryPort;

    public PlaylistServiceImp(PlaylistRespositoryPort playlistRespositoryPort, SongRepositoryPort songRepositoryPort) {
        this.playlistRespositoryPort = playlistRespositoryPort;
        this.songRepositoryPort = songRepositoryPort;
    }

    @Override
    public Playlist addSongsToPlaylist(String id, List<SongDTO> songs) throws SongsNotFoundException, PlaylistsNotFoundException {
        Playlist playlist = this.playlistRespositoryPort.findById(id);
        for (SongDTO songDTO : songs) {
            Song song = this.songRepositoryPort.findById(songDTO.getId());
            playlist.getSongs().add(song);
        }

        this.playlistRespositoryPort.addSong(new PlaylistEntity(playlist));

        return playlist;
    }
}
