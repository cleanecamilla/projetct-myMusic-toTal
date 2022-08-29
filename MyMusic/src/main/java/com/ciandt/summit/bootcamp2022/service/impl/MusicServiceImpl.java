package com.ciandt.summit.bootcamp2022.service.impl;

import com.ciandt.summit.bootcamp2022.entity.Music;
import com.ciandt.summit.bootcamp2022.repository.MusicRepository;
import com.ciandt.summit.bootcamp2022.dto.MusicDTO;
import com.ciandt.summit.bootcamp2022.exception.MusicNotFound;
import com.ciandt.summit.bootcamp2022.service.MusicService;
import com.ciandt.summit.bootcamp2022.service.mapper.MusicDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService {

    private final MusicRepository musicRepository;
    private final MusicDTOMapper musicDTOMapper;

    public Set<MusicDTO> findAllWithFilter(String filter) {

        Set<Music> musicSet = musicRepository
                .findAllWithFilter(filter)
                .orElseThrow(IllegalAccessError::new);

        if (musicSet.isEmpty())
            throw new MusicNotFound();

        return musicDTOMapper.toSetOfDTO(musicSet);
    }
}
