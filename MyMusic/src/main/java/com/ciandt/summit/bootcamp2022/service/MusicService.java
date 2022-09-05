package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.dto.MusicDTO;
import com.ciandt.summit.bootcamp2022.entity.Music;

import java.util.Optional;
import java.util.Set;

public interface MusicService {

    Set<MusicDTO> findAllWithFilter(String filter);

    Music findById(String id);
}
