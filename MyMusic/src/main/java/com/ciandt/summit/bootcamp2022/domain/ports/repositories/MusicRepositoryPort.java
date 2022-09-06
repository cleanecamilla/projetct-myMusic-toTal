package com.ciandt.summit.bootcamp2022.domain.ports.repositories;

import com.ciandt.summit.bootcamp2022.domain.Music;

import java.util.Set;

public interface MusicRepositoryPort {

    Set<Music> getMusicsByFilter(String name);
    Set<Music> searchMusics();

    void save(Music music);

}
