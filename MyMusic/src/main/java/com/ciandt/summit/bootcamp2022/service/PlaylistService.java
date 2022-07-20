package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.controller.request.PlaylistRequest;
import com.ciandt.summit.bootcamp2022.entity.Playlist;

public interface PlaylistService {

    Playlist adicionarMusicaNaPlaylist(String playlistId, PlaylistRequest musica);

    Playlist buscarPlaylistPorId(String playlistId);
}
