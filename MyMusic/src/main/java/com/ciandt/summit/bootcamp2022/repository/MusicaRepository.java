package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Musica;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface  MusicaRepository {

    List<Musica> encontrarMusicaPeloNome(String nome);

}
