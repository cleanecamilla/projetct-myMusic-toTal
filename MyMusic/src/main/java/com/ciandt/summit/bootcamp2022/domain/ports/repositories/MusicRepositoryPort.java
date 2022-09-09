package com.ciandt.summit.bootcamp2022.domain.ports.repositories;

import com.ciandt.summit.bootcamp2022.domain.Music;
import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;

import java.util.Set;

public interface MusicRepositoryPort {

    Set<Music> getMusicsByFilter(String name);
    Set<Music> searchMusics();

    void save(MusicDTO musicDTO);

}
