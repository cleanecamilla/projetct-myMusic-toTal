package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Artist;
import com.ciandt.summit.bootcamp2022.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MusicRepository extends JpaRepository<Music, String> {

    Set<Music> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

    Set<Music> findByArtist(Artist artist);
}
