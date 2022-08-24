package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.infra.adapters.entities.SongEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SpringSongRepository extends JpaRepository<SongEntity, String> {
    @Query("SELECT s FROM SongEntity s " +
            "JOIN ArtistEntity a on s.artist.id = a.id " +
            "WHERE s.name LIKE :name% " +
            "OR a.name LIKE :name% " +
            "ORDER BY a.name, s.name"
    )
    Page<SongEntity> findByNameOrArtistName(@Param("name") String name, Pageable pageable);

    Page<SongEntity> findSongtById(String s, Pageable ofSize);
}
