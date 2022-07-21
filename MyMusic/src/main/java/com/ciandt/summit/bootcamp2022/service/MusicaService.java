package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.entity.Musica;

import java.util.List;

public interface MusicaService {

    List<Musica> buscarMusicas(String filtro);

    Musica buscarMusicaPorId(String id);
}
