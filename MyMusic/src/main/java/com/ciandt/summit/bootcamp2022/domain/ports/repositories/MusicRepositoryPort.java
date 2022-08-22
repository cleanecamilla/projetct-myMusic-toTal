package com.ciandt.summit.bootcamp2022.domain.ports.repositories;

import com.ciandt.summit.bootcamp2022.domain.Music;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MusicRepositoryPort extends JpaRepository<MusicEntity, String> {
    Set<Music> getMusicsByFilter(); //-> provisory
}
