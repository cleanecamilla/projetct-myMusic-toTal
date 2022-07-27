package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ArtistaRepository extends JpaRepository<Artista, String> {

    Set<Artista> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);

}
