package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Music;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface MusicRepository extends JpaRepository<Music, String> {

    @Query(value = "SELECT msc FROM Music msc " +
            "   JOIN FETCH msc.artist art " +
            "   WHERE :name IS NULL" +
            "   OR UPPER(msc.name) LIKE UPPER('%'||:name||'%') " +
            "   OR UPPER(msc.artist.name) LIKE UPPER('%'||:name||'%') "
    )
    Set<Music> findAllWithFilter(@Param("name") String name, Sort sort);

}
