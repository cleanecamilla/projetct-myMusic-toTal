package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.controller.dto.MusicaDto;
import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    public MusicaDto buscar(String filtro){
        if(filtro.length() < 3){
            System.out.println("Quantidade de caracteres inválida!");
        }
        List<Musica> lista = musicaRepository.buscarMusicaArtista(filtro);
        return new MusicaDto(lista);
    }
}
