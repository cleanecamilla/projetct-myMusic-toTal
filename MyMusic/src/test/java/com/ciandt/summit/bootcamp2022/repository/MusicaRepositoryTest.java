package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Artista;
import com.ciandt.summit.bootcamp2022.entity.Musica;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MusicaRepositoryTest {

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Nested
    @DisplayName("Testar metodos de buscar musicas por nome")
    public class BuscaPorNomeTest {

        Set<Musica> musicas;

        @DisplayName(value = "Buscar pelo nome completo")
        @ParameterizedTest(name = "A música {0}")
        @ValueSource(strings = {"\"Cassius\" Love Vs. \"Sonny\" Wilson", "313"})
        public void testarBuscaDeMusicasPeloNomeCompleto(String nome) {
            musicas = musicaRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nome);
            musicas.forEach(m -> assertEquals(nome, m.getNome(),
                    () -> "Deve retornar a música buscada pelo nome completo"));
            assertEquals(1, musicas.size(), () -> "Deve retornar uma musica apenas");
        }

        @DisplayName("Buscar varias musicas")
        @ParameterizedTest(name = "Pela parte do nome {0}")
        @ValueSource(strings = {"Love", "Help!"})
        public void testarBuscaDeVariasMusicasPorParteDoNome(String nome) {
            musicas = musicaRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nome);

            musicas.forEach(m -> assertTrue(m.getNome().toLowerCase().contains(nome.toLowerCase()),
                    () -> "Deve retornar varias musicas por parte do nome"));
        }

        @DisplayName("Buscar varias musicas e retornar ordenadas")
        @ParameterizedTest(name = "Pelo nome ou parte do nome {0}")
        @ValueSource(strings = {"Love", "Help!"})
        public void testarBuscaDeVariasMusicasOrdenadasPorParteDoNome(String nome) {
            musicas = musicaRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nome);

            Set<Musica> musicasOrdenadas = musicas.stream()
                    .sorted(Comparator.comparing(m -> m.getNome().toLowerCase()))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            assertEquals(musicas,
                    musicasOrdenadas,
                    () -> "Deve retornar o set de musicas ordenados pelo nome");
        }

        @DisplayName("Buscar músicas ignorando case")
        @ParameterizedTest(name = "Com o nome {0}")
        @ValueSource(strings = {"falling like rain", "STRAWBERRY FIELDS FOREVER"})
        public void testarBuscaDeArtistasPeloNomeSemCase(String nomeSemCase) {
            musicas = musicaRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nomeSemCase);

            musicas.forEach(m ->
                    assertEquals(nomeSemCase.toLowerCase(),
                            m.getNome().toLowerCase(), () -> "Deve retornar a musica sem case"));
        }

        @DisplayName("Buscar musicas nao existentes")
        @ParameterizedTest(name = "Com o nome invalido {0}")
        @ValueSource(strings = {"NOMEINVALIDO", "$@#%25"})
        public void testarBuscasSemRetorno(String nomeInvalido) {
            musicas = musicaRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nomeInvalido);

            assertEquals(0, musicas.size(), () -> "Nao deve retornar musicas");
        }

        @DisplayName("Buscar musicas com o nome vazio")
        @Test
        public void testarRetornoCasoOParametroSejaVazio() {
            musicas = musicaRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc("");
            assertNotEquals(0, musicas.size(), () -> "Deve retornar todos os artistas");
        }
    }

    @Nested
    @DisplayName("Testar metodos de buscar musicas pelo artista")
    public class BuscaPorArtistaTest {

        Set<Artista> artistas;
        Set<Musica> musicasPorArtista;
        Artista artista;

        @DisplayName(value = "Buscar musicas pelo artista")
        @ParameterizedTest(name = "Com o nome {0}")
        @ValueSource(strings = {"Björk", "Jimi Hendrix"})
        public void testarBuscaDeMusicasPeloArtista(String nome) {
            artista = this.retornarArtistaHelper(nome);
            musicasPorArtista = musicaRepository.findByArtista(artista);

            musicasPorArtista.forEach(m -> assertEquals(artista, m.getArtista()));
        }

        @DisplayName(value = "Buscar musicas ordenadas pelo artista")
        @ParameterizedTest(name = "Com o nome {0}")
        @ValueSource(strings = {"Björk", "Jimi Hendrix"})
        public void testarBuscaDeMusicasPeloArtistaOrdenadas(String nome) {
            artista = this.retornarArtistaHelper(nome);
            musicasPorArtista = musicaRepository.findByArtista(artista);
            Set<Musica> musicasOrdenadas = musicasPorArtista.stream()
                    .sorted(Comparator.comparing(m -> m.getNome().toLowerCase()))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            assertEquals(musicasOrdenadas, musicasPorArtista,
                    () -> "Deve retornar o set de músicas do artista ordenado por nome");
        }

        @DisplayName(value = "Buscar musicas por artista null")
        @Test
        public void testarBuscaDeMusicasPorArtistaNull() {
            musicasPorArtista = musicaRepository.findByArtista(null);

            assertEquals(0, musicasPorArtista.size(), () -> "Deve retornar vazio pois não buscou artista");
        }

        private Artista retornarArtistaHelper(String nome) {
            artistas = artistaRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nome);
            Optional<Artista> artista = artistas.stream().findFirst();
            return artista.orElse(null);
        }
    }

}
