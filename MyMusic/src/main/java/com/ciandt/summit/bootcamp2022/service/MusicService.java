package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.entity.Music;
import com.ciandt.summit.bootcamp2022.repository.MusicRepository;
import com.ciandt.summit.bootcamp2022.service.dto.MusicDTO;
import com.ciandt.summit.bootcamp2022.service.exception.MinFilterLenghtException;
import com.ciandt.summit.bootcamp2022.service.exception.MusicNotFound;
import com.ciandt.summit.bootcamp2022.service.mapper.MusicDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;
    private final MusicDTOMapper musicDTOMapper;

    public Set<MusicDTO> findAllWithFilterByName(String name) {

        if (name.length() <= 2)
            throw new MinFilterLenghtException();

        Set<Music> musicSet = musicRepository
                .findAllWithFilterByName(name)
                .orElseThrow(IllegalAccessError::new);

        if (musicSet.isEmpty())
            throw new MusicNotFound();

        return musicDTOMapper.toSetOfDTO(musicSet);
    }
}
