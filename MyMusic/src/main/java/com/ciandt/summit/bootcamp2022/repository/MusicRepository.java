package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface MusicRepository extends JpaRepository<Music, String> {
    @Query(value = "SELECT * FROM Musicas as msc " +
            "JOIN Artistas AS art " +
            "ON art.Id = msc.artistaId " +
            "WHERE msc.Nome LIKE '%'||:name||'%' " +
            "OR art.Nome LIKE '%'||:name||'%' " +
            "ORDER BY art.Nome, msc.Nome",

            nativeQuery = true)
    Optional<Set<Music>> findAllWithFilterByName(@Param("name") String name);

}
