package com.ciandt.summit.bootcamp2022.domain.adapters.services;

import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import com.ciandt.summit.bootcamp2022.domain.ports.interfaces.MusicServicePort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MusicServiceImpl implements MusicServicePort {

    @Autowired
    MusicServicePort musicServicePort; // a service só se comunica por meio das portas.

    @Override
    public Set<MusicDTO> searchMusics() {
        // business logic
        return null;
    }

    // chama a musicServicePort
    // aqui é montado a regra de negócio - regra de negócio do controller
}
