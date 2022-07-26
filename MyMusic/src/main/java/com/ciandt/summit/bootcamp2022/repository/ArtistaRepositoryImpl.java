package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ArtistaRepositoryImpl extends JpaRepository<Artista, String>, ArtistaRepository {

    @Override
    Set<Artista> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);

}
