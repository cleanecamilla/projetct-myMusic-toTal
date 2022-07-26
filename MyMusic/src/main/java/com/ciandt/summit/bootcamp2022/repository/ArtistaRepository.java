package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Artista;
import java.util.Set;

public interface ArtistaRepository {
    public Set<Artista> encontrarArtistaPeloNome(String nome);
}
