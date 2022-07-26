package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Artista;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ArtistaRepository {
    Set<Artista> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);

}
