package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.controller.request.PlaylistRequest;
import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.entity.Playlist;
import com.ciandt.summit.bootcamp2022.entity.PlaylistMusica;
import com.ciandt.summit.bootcamp2022.entity.PlaylistMusicaKey;
import com.ciandt.summit.bootcamp2022.exception.NaoPermitidoSalvarAMesmaMusicaException;
import com.ciandt.summit.bootcamp2022.exception.PayloadBodyInvalidoException;
import com.ciandt.summit.bootcamp2022.exception.PlaylistNaoContemMusicaException;
import com.ciandt.summit.bootcamp2022.exception.PlaylistNaoExisteException;
import com.ciandt.summit.bootcamp2022.model.MusicaDTO;
import com.ciandt.summit.bootcamp2022.repository.PlaylistMusicaRepository;
import com.ciandt.summit.bootcamp2022.repository.PlaylistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistServiceImp implements PlaylistService {

    private static final Logger logger = LoggerFactory.getLogger(PlaylistServiceImp.class);

    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private PlaylistMusicaRepository playlistMusicaRepository;
    @Autowired
    private MusicaServiceImp musicaServiceImp;

    @Override
    public PlaylistMusica adicionarMusicaNaPlaylist(String playlistId, PlaylistRequest musicaRequest) {
        buscarPlaylistPorId(playlistId);

        Musica musicaDb = musicaServiceImp.buscarMusicaPorId(musicaRequest.getData().getId());

        validarPayloadBodyRequest(musicaRequest.getData(), musicaDb);

        Optional<PlaylistMusica> relacaoPlaylistMusica = playlistMusicaRepository.findByPlaylistIdAndMusicaId(playlistId, musicaRequest.getData().getId());

        if (relacaoPlaylistMusica.isPresent()) {
            throw new NaoPermitidoSalvarAMesmaMusicaException("Música duplicada.");
        }

        PlaylistMusica playlistMusica = new PlaylistMusica(new PlaylistMusicaKey(playlistId, musicaRequest.getData().getId()));

        playlistMusicaRepository.save(playlistMusica);

        return playlistMusica;
    }

    public void validarPayloadBodyRequest(MusicaDTO musicaRequest, Musica musicaDb) {
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

    @Override
    public void removerMusicaFromPlaylist(String playlistId, String musicaId) {
        Playlist playlist = buscarPlaylistPorId(playlistId);
        Musica musica = musicaServiceImp.buscarMusicaPorId(musicaId);
        if (playlistMusicaRepository.findByPlaylistIdAndMusicaId(playlistId, musicaId).isPresent()) {
            playlistMusicaRepository.deleteById(new PlaylistMusicaKey(playlistId, musicaId));
        } else {
            throw new PlaylistNaoContemMusicaException(playlistId + " " + musicaId);
        }
        logger.info("Removendo a musica " + musica + " da playlist " + playlist.getId());
    }
}
