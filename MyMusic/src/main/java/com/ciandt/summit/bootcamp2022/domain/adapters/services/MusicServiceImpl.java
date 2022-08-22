package com.ciandt.summit.bootcamp2022.domain.adapters.services;

import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import com.ciandt.summit.bootcamp2022.domain.ports.interfaces.MusicServicePort;

import java.util.Set;

public class MusicServiceImpl implements MusicServicePort {

    @Override
    public Set<MusicDTO> searchMusics() {
        // business logic
        return null;
    }
}
