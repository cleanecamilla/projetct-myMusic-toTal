package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Artista;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ArtistaRepositoryTest {

    @Autowired
    private ArtistaRepository artistaRepository;

    @DisplayName(value = "Buscar pelo nome completo")
    @ParameterizedTest(name = "O artista {0}")
    @ValueSource(strings = {"Björk", "Jimi Hendrix"})
    public void testarBuscaDeArtistasPeloNomeCompleto(String nome) {
        Set<Artista> artistas = artistaRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nome);
        artistas.forEach(a -> assertEquals(nome, a.getNome(),
                () -> "Deve retornar o artista buscado pelo nome completo"));
    }

    @DisplayName("Buscar varios artistas")
    @ParameterizedTest(name = "Pela parte do nome {0}")
    @ValueSource(strings = {"Mary", "rs"})
    public void testarBuscaDeVariosArtistasPorParteDoNome(String nome) {
        artistas = artistaRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nome);

        artistasSemCase.forEach(a -> assertTrue(a.getNome().contains(nome)));
    }

    @DisplayName("Buscar varios artistas e retornar ordenados")
    @ParameterizedTest(name = "Pelo nome ou parte do nome {0}")
    @ValueSource(strings = {"Mary", "rs"})
    public void testarBuscaDeVariosArtistasOrdenadosPorParteDoNome(String nome) {
        Set<Artista> artistasOrdenadosPeloRepository =
                artistaRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nome);

        Set<Artista> artistasOrdenados = artistasOrdenadosPeloRepository.stream()
                .sorted(Comparator.comparing(a -> a.getNome().toLowerCase()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        assertEquals(artistasOrdenadosPeloRepository,
                artistasOrdenados,
                () -> "Deve retornar o set de artistas ordenados pelo nome");
    }

    @DisplayName("Buscar artistas ignorando case")
    @ParameterizedTest(name = "Com o nome {0}")
    @ValueSource(strings = {"björk", "CAPITAL INICIAL"})
    public void testarBuscaDeArtistasPeloNomeSemCase(String nomeSemCase) {
        Set<Artista> artistasSemCase =
                artistaRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nomeSemCase);

        assertEquals(1, artistasSemCase.size(), () -> "Deve retornar o artista como esta no banco");
        artistasSemCase.forEach(a ->
                assertEquals(nomeSemCase.toLowerCase(),
                        a.getNome().toLowerCase(), () -> "Deve retornar o artista sem case"));
    }

    @DisplayName("Buscar artistas nao existentes")
    @ParameterizedTest(name = "Com o nome invalido {0}")
    @ValueSource(strings = {"NOMEINVALIDO", "$@#%25"})
    public void testarBuscasSemRetorno(String nomeInvalido) {
        Set<Artista> artistasSemCase =
                artistaRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nomeInvalido);

        assertEquals(0, artistasSemCase.size(), () -> "Nao deve retornar artistas");
    }

    @DisplayName("Buscar artistas com o nome vazio")
    @Test
    public void testarRetornoCasoOParametroSejaVazio() {
        artistas = artistaRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc("");
        assertNotEquals(0, artistas.size(), () -> "Deve retornar todos os artistas");
    }
}
