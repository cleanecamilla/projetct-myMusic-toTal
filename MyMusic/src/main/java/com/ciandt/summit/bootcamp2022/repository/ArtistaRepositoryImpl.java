package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ArtistaRepositoryImpl extends JpaRepository<Artista, String>, ArtistaRepository {

    @Override
    @Query(value = "SELECT * FROM Artistas a WHERE a.nome LIKE '%:nome%", nativeQuery = true)
    public Set<Artista> encontrarArtistaPeloNome(String nome);

}
