package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.domain.Music;
import com.ciandt.summit.bootcamp2022.domain.ports.repositories.MusicRepositoryPort;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.MusicEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

@Component
public class MusicRepository implements MusicRepositoryPort {

    private final SpringMusicRepository springMusicRepository;

    public MusicRepository(SpringMusicRepository springMusicRepository) {
        this.springMusicRepository = springMusicRepository;
    }

    @Override
    public Set<Music> getMusicsByFilter() {
        // business logic
        return null;
    }

}
