package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

    public interface MusicaRepositoryImpl extends JpaRepository<Musica, String>, MusicaRepository {

        @Override
        @Query(value = "SELECT m FROM Musica m JOIN Artista a on a.id = m.artista WHERE a.nome like '%'|| :param ||'%' or m.nome like '%'|| :param ||'%' ORDER by a.nome, m.nome asc", nativeQuery = true)
        List<Musica> encontrarMusicaPeloNome(@Param("param") String nome);
    }
