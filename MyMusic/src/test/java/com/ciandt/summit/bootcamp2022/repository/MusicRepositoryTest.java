package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Artist;
import com.ciandt.summit.bootcamp2022.entity.Music;
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
public class MusicRepositoryTest {

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Nested
    @DisplayName("Test methods to find music by name")
    public class FindMusicByNameTest {

        Set<Music> musics;

        @DisplayName(value = "Find music")
        @ParameterizedTest(name = "By full name {0}")
        @ValueSource(strings = {"\"Cassius\" Love Vs. \"Sonny\" Wilson", "313"})
        public void testFindMusicsByFullName(String name) {
            musics = musicRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);
            musics.forEach(m -> assertEquals(name, m.getName(),
                    () -> "Should return music by full name"));
        }

        @DisplayName("Find multiple musics")
        @ParameterizedTest(name = "By part of the name {0}")
        @ValueSource(strings = {"Love", "Help!"})
        public void testFindMultipleMusicsByPartOfTheName(String name) {
            musics = musicRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);

            musics.forEach(m -> assertTrue(m.getName().toLowerCase().contains(name.toLowerCase()),
                    () -> "Should return multiple musics by part of the name"));
        }

        @DisplayName("Find multiple musics and return in order")
        @ParameterizedTest(name = "By name or part of the name {0}")
        @ValueSource(strings = {"Love", "Help!"})
        public void testFindMultipleMusicsOrderedByNameOrPartOfTheName(String name) {
            musics = musicRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);

            Set<Music> musicsOrdered = musics.stream()
                    .sorted(Comparator.comparing(m -> m.getName().toLowerCase()))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            assertEquals(musics,
                    musicsOrdered,
                    () -> "Should return a set of musics ordered by name");
        }

        @DisplayName("Find musics ignoring case")
        @ParameterizedTest(name = "with name {0}")
        @ValueSource(strings = {"falling like rain", "STRAWBERRY FIELDS FOREVER"})
        public void testFindMusicsByNameIgnoringCase(String name) {
            musics = musicRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);

            musics.forEach(m ->
                    assertEquals(name.toLowerCase(),
                            m.getName().toLowerCase(), () -> "Should return music ignoring case"));
        }

        @DisplayName("Find non-existing musics")
        @ParameterizedTest(name = "With invalid name {0}")
        @ValueSource(strings = {"INVALID_NAME", "$@#%25"})
        public void testFindWithNoReturn(String name) {
            musics = musicRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);

            assertEquals(0, musics.size(), () -> "Shouldn't return any musics");
        }

        @DisplayName("Find musics with empty parameter")
        @Test
        public void testReturnIfParameterIsEmpty() {
            musics = musicRepository.findByNameContainingIgnoreCaseOrderByNameAsc("");
            assertNotEquals(0, musics.size(), () -> "Should return all musics");
        }
    }

    @Nested
    @DisplayName("Test methods to find music by artist")
    public class FindMusicByArtistTest {

        Set<Artist> artists;
        Set<Music> musicsByArtist;
        Artist artist;

        @DisplayName(value = "Find musics by artist")
        @ParameterizedTest(name = "With name {0}")
        @ValueSource(strings = {"Björk", "Jimi Hendrix"})
        public void testFindMusicsByArtist(String name) {
            artist = this.returnArtistHelper(name);
            musicsByArtist = musicRepository.findByArtist(artist);

            musicsByArtist.forEach(m -> assertEquals(artist, m.getArtist(),
                    () -> "Should return all musics by artist"));
        }

        @DisplayName(value = "Find musics in order by artist")
        @ParameterizedTest(name = "With name {0}")
        @ValueSource(strings = {"Björk", "Jimi Hendrix"})
        public void testFindMusicsByArtistInOrder(String name) {
            artist = this.returnArtistHelper(name);
            musicsByArtist = musicRepository.findByArtist(artist);
            Set<Music> musicsOrdered = musicsByArtist.stream()
                    .sorted(Comparator.comparing(m -> m.getName().toLowerCase()))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            assertEquals(musicsOrdered, musicsByArtist,
                    () -> "Should return set of an artist's musics ordered by their names");
        }

        @DisplayName(value = "Find musics by null artist")
        @Test
        public void testFindMusicsByNullArtist() {
            musicsByArtist = musicRepository.findByArtist(null);

            assertEquals(0, musicsByArtist.size(),
                    () -> "Should return empty because it didn't return any artist");
        }

        private Artist returnArtistHelper(String name) {
            artists = artistRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);
            Optional<Artist> artist = artists.stream().findFirst();
            return artist.orElse(null);
        }
    }

}
