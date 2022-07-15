package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.SummitBootcampApplication;
import com.ciandt.summit.bootcamp2022.controller.dto.MusicaDto;
import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.exceptions.FiltroErrorException;
import com.ciandt.summit.bootcamp2022.repository.MusicaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SummitBootcampApplication.class);

    @Autowired
    private MusicaRepository musicaRepository;


    public MusicaDto buscar(String filtro){

        if(filtro.length() < 3){
            LOGGER.error("Erro ao filtrar musicas!");
            throw new FiltroErrorException();
        }

        List<Musica> lista = musicaRepository.buscarMusicaArtista(filtro);

        LOGGER.info("Musicas filtradas com sucesso!");
        return new MusicaDto(lista);
    }
}
