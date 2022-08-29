package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.entity.Music;
import com.ciandt.summit.bootcamp2022.repository.MusicRepository;
import com.ciandt.summit.bootcamp2022.service.dto.MusicDTO;
import com.ciandt.summit.bootcamp2022.service.exception.MusicNotFound;
import com.ciandt.summit.bootcamp2022.service.mapper.MusicDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;
    private final MusicDTOMapper musicDTOMapper;

    public Set<MusicDTO> findAllWithFilterByName(String name) {

        Set<Music> musicSet = musicRepository
                .findAllWithFilterByName(name)
                .orElseThrow(IllegalAccessError::new);

        if (musicSet.isEmpty())
            throw new MusicNotFound();

        return musicDTOMapper.toSetOfDTO(musicSet);
    }
}
