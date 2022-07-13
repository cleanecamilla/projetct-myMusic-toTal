package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.entity.Musica;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MusicaService {

    List<Musica> buscarMusicas(String filtro);
}
