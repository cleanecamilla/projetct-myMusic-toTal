package com.ciandt.summit.bootcamp2022.domain.ports.interfaces;

import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;

import java.util.Set;

public interface MusicServicePort {
    Set<MusicDTO> searchMusics();

    // nessa interface tem que ter os nomes dos métodos. findByName(String name);
}
