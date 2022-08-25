package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.infra.adapters.entities.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringPlaylistRepository extends JpaRepository<PlaylistEntity, String> {


 }
