package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ArtistRepository extends JpaRepository<Artist, String> {

    Set<Artist> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

}
