package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.infra.adapters.entities.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringMusicRepository extends JpaRepository<MusicEntity, String> {
    List<MusicEntity> findByNomeContains(String name);
}
