package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.domain.Music;
import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import com.ciandt.summit.bootcamp2022.domain.ports.repositories.MusicRepositoryPort;
import com.ciandt.summit.bootcamp2022.exceptions.NoContentException;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.MusicEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MusicRepository implements MusicRepositoryPort {

    private final SpringMusicRepository springMusicRepository;

    public MusicRepository(SpringMusicRepository springMusicRepository) {
        this.springMusicRepository = springMusicRepository;
    }

    @Override
    public Set<Music> getMusicsByFilter(String name) {
        List<MusicEntity> musicEntityList = springMusicRepository.findByNomeContains(name);
        Set<Music> musicDTOList = musicEntityList.stream()
                .map(MusicEntity::toMusic)
                .collect(Collectors.toSet());
        return musicDTOList;
    }

    @Override
    public Set<Music> searchMusics() {
        return springMusicRepository.findAll().stream().map(MusicEntity::toMusic).collect(Collectors.toSet());
    }

    @Override
    public void save(MusicDTO music) {
        MusicEntity musicEntity;
        if (Objects.isNull(music.getId())) {
            musicEntity = new MusicEntity(music.getId(), music.getName(), music.getArtistId());
            springMusicRepository.save(musicEntity);
        }
    }
}
