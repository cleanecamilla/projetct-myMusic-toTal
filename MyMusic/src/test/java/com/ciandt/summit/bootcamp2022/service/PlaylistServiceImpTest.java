package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.controller.request.PlaylistRequest;
import com.ciandt.summit.bootcamp2022.entity.Artista;
import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.entity.Playlist;
import com.ciandt.summit.bootcamp2022.exception.MusicaNaoExisteException;
import com.ciandt.summit.bootcamp2022.exception.PayloadBodyInvalidoException;
import com.ciandt.summit.bootcamp2022.exception.PlaylistNaoExisteException;
import com.ciandt.summit.bootcamp2022.repository.PlaylistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PlaylistServiceImpTest {

    @InjectMocks
    private PlaylistServiceImp playlistServiceImp;

    @Mock
    private MusicaServiceImp musicaServiceImp;

    @Mock
    private PlaylistRepository playlistRepository;


    @Test
    void test_buscaPlaylistIdCorreto(){
        Musica mR1 = new Musica("b97e179d-76f1-44bb-a04f-1d678c1269ff", "Marseilles", new Artista("771bc41f-20dd-418b-9df1-5b01e8cf0658","Brian Eno"));
        PlaylistRequest pR1 = new PlaylistRequest(mR1);
        Playlist p1 = new Playlist("93f7da42-d9e5-4e50-a789-b4f406897dd7", new ArrayList<>());

        given(playlistRepository.findById(p1.getId())).willReturn(Optional.of(p1));

        assertEquals(p1, playlistServiceImp.buscarPlaylistPorId(p1.getId()));
    }

    @Test
    void test_buscaPlaylistIdIncorreto(){
        Musica mR1 = new Musica("b97e179d-76f1-44bb-a04f-1d678c1269ff", "Marseilles", new Artista("771bc41f-20dd-418b-9df1-5b01e8cf0658","Brian Eno"));
        PlaylistRequest pR1 = new PlaylistRequest(mR1);
        Playlist p1 = new Playlist("93f7da42-d9e-4e50-a789-b4f406897dd7", new ArrayList<>());

       assertThrows(PlaylistNaoExisteException.class, () -> playlistServiceImp.buscarPlaylistPorId(p1.getId()));
    }

    @Test
    void test_adicionarMusicaPlaylistCorreto(){
        Musica mR1 = new Musica("b97e179d-76f1-44bb-a04f-1d678c1269ff", "Marseilles", new Artista("771bc41f-20dd-418b-9df1-5b01e8cf0658","Brian Eno"));
        PlaylistRequest pR1 = new PlaylistRequest(mR1);
        Playlist p1 = new Playlist("93f7da42-d9e5-4e50-a789-b4f406897dd7", new ArrayList<>());

        given(playlistRepository.findById(p1.getId())).willReturn(Optional.of(p1));
        given(musicaServiceImp.buscarMusicaPorId(mR1.getId())).willReturn(mR1);

        List<Musica> musicas = p1.getMusicas();
        musicas.add(pR1.getData());
        p1.setMusicas(musicas);

        assertEquals(p1, playlistServiceImp.adicionarMusicaNaPlaylist(p1.getId(), pR1));
    }

    @Test
    void test_adicionarMusicaPlaylistIdIncorreto(){
        Musica mR1 = new Musica("b97e179d-76f1-44bb-a04f-1d678c1269ff", "Marseilles", new Artista("771bc41f-20dd-418b-9df1-5b01e8cf0658","Brian Eno"));
        PlaylistRequest pR1 = new PlaylistRequest(mR1);
        Playlist p1 = new Playlist("93f7da42-d9e5-4e50-a7-b4f406897dd7", new ArrayList<>());

        given(playlistRepository.findById(p1.getId())).willThrow(PlaylistNaoExisteException.class);

        assertThrows(PlaylistNaoExisteException.class, () -> playlistServiceImp.adicionarMusicaNaPlaylist(p1.getId(), pR1));
    }

    @Test
    void test_adicionarMusicaPlaylistMusicaIdIncorreto(){
        Musica mR1 = new Musica("b97e179d-76f1-44bb-a04f-1d678c1269", "Marseilles", new Artista("771bc41f-20dd-418b-9df1-5b01e8cf0658","Brian Eno"));
        PlaylistRequest pR1 = new PlaylistRequest(mR1);
        Playlist p1 = new Playlist("93f7da42-d9e5-4e50-a789-b4f406897dd7", new ArrayList<>());

        given(playlistRepository.findById(p1.getId())).willReturn(Optional.of(p1));
        given(musicaServiceImp.buscarMusicaPorId(mR1.getId())).willThrow(MusicaNaoExisteException.class);

        assertThrows(MusicaNaoExisteException.class, () -> playlistServiceImp.adicionarMusicaNaPlaylist(p1.getId(), pR1));
    }

    @Test
    void test_PayloadBodyIncorreto(){
        Musica mR1 = new Musica("b97e179d-76f1-44bb-a04f-1d678c1269ff", "", new Artista("",""));
        Musica m1 = new Musica("b97e179d-76f1-44bb-a04f-1d678c1269ff", "Marseilles", new Artista("771bc41f-20dd-418b-9df1-5b01e8cf0658","Brian Eno"));

        assertThrows(PayloadBodyInvalidoException.class, () -> playlistServiceImp.validarPayloadBodyRequest(mR1,m1));
    }

}