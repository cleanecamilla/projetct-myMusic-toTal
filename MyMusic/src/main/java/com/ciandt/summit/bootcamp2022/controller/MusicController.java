package com.ciandt.summit.bootcamp2022.controller;

import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.exception.MusicaNaoEncontradaException;
import com.ciandt.summit.bootcamp2022.service.MusicaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class MusicController {

    @Autowired   private MusicaServiceImp musicaServiceImp;

    @GetMapping("/musicas")
    public ResponseEntity<List<Musica>> buscarMusica(@RequestParam String filtro){
        List<Musica> musicas =  musicaServiceImp.buscarMusicas(filtro);
        if(musicas.isEmpty()){
            throw new MusicaNaoEncontradaException("Música não encontrada!");
        }
        return new ResponseEntity<List<Musica>>(musicas, HttpStatus.OK);
    }
}

