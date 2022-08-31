package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.dto.MusicDTO;

import java.util.Set;

public interface MusicService {

    Set<MusicDTO> findAllWithFilter(String filter);
}
