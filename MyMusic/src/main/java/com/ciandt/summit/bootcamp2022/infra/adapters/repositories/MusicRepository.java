package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.domain.Music;
import com.ciandt.summit.bootcamp2022.domain.ports.repositories.MusicRepositoryPort;
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

        if (name.length() < 3) {
            throw new IllegalArgumentException("Insira um nome com 3 caracteres ou mais");
        } else if (name==null){
            throw new IllegalArgumentException("Insira um nome");
        }
        return musicDTOList;
    }

    @Override
    public Set<Music> searchMusics() {
        return springMusicRepository.findAll().stream().map(MusicEntity::toMusic).collect(Collectors.toSet());
    }

    @Override
    public void save(Music music) {
        MusicEntity musicEntity;
        if (Objects.isNull(music.getId())) {
            musicEntity = new MusicEntity(music.getId(), music.getName(), music.getArtistId());
            springMusicRepository.save(musicEntity);
        }
    }
}
