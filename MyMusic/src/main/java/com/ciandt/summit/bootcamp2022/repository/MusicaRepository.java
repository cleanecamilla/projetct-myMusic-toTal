package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Artista;
import com.ciandt.summit.bootcamp2022.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MusicaRepository extends JpaRepository<Musica, String> {

    Set<Musica> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);

    Set<Musica> findByArtista(Artista artista);
}
