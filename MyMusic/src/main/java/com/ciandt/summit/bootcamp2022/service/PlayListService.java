package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.entity.PlayList;
import com.ciandt.summit.bootcamp2022.exceptions.MusicaNaoEncontradaException;
import com.ciandt.summit.bootcamp2022.exceptions.PlayListNaoEncontradaException;
import com.ciandt.summit.bootcamp2022.repository.MusicaRepository;
import com.ciandt.summit.bootcamp2022.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PlayListService {

    @Autowired
    private PlayListRepository playListRepository;

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private MusicaService musicaService;

    public void adicionarMusicaNaPlayList(String idMusica, String idPlayList){

        Musica musica = musicaRepository.findById(idMusica).orElseThrow(()-> new MusicaNaoEncontradaException());
        PlayList playList = playListRepository.findById(idPlayList).orElseThrow(()-> new PlayListNaoEncontradaException());

        playList.setMusicas(Arrays.asList(musica));
        playListRepository.save(playList);
    }
}