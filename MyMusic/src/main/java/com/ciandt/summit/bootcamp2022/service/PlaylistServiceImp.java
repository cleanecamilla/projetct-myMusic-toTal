package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.controller.request.PlaylistRequest;
import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.entity.Playlist;
import com.ciandt.summit.bootcamp2022.exception.PayloadBodyInvalidoException;
import com.ciandt.summit.bootcamp2022.exception.PlaylistNaoExisteException;
import com.ciandt.summit.bootcamp2022.repository.PlaylistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class PlaylistServiceImp implements PlaylistService{

    private static final Logger logger = LoggerFactory.getLogger(PlaylistServiceImp.class);

    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private MusicaServiceImp musicaServiceImp;

    @Override
    public Playlist adicionarMusicaNaPlaylist(String playlistId, PlaylistRequest musicaRequest) {
        Playlist playlist = buscarPlaylistPorId(playlistId);

        Musica musicaDb = musicaServiceImp.buscarMusicaPorId(musicaRequest.getData().getId());

        validarPayloadBodyRequest(musicaRequest.getData(), musicaDb);

        Set<Musica> musicas = new HashSet<>(playlist.getMusicas());
        musicas.add(musicaRequest.getData());
        playlist.setMusicas(new ArrayList<>(musicas));

        playlistRepository.save(playlist);

        return playlist;
    }

    public void validarPayloadBodyRequest(Musica musicaRequest, Musica musicaDb) {
        logger.info("Validando payload do RequestBody");
        if (!musicaDb.getNome().equalsIgnoreCase(musicaRequest.getNome())
                || !musicaDb.getArtista().getId().equals(musicaRequest.getArtista().getId())
                || !musicaDb.getArtista().getNome().equals(musicaRequest.getArtista().getNome())) {
            logger.error("Payload inválido.");
            throw new PayloadBodyInvalidoException(musicaRequest.getId());
        }
    }

    @Override
    public Playlist buscarPlaylistPorId(String playlistId) {
        logger.info("Buscando playlist com id: " + playlistId);
        return playlistRepository.findById(playlistId).orElseThrow(() -> new PlaylistNaoExisteException(playlistId));
    }

}
