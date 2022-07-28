package com.ciandt.summit.bootcamp2022.repository;

import com.ciandt.summit.bootcamp2022.entity.Artist;
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
public class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository artistRepository;
    Set <Artist> artists;

    @DisplayName(value = "Find artist")
    @ParameterizedTest(name = "By full name {0}")
    @ValueSource(strings = {"Björk", "Jimi Hendrix"})
    public void testFindArtistsByFullName(String name) {
        artists = artistRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);
        artists.forEach(a -> assertEquals(name, a.getName(),
                () -> "Should return artist by full name"));
    }

    @DisplayName("Find multiple artists")
    @ParameterizedTest(name = "By part of the name {0}")
    @ValueSource(strings = {"Mary", "rs"})
    public void testFindMultipleArtistsByPartOfTheName(String name) {
        artists = artistRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);

        artists.forEach(a -> assertTrue(a.getName().toLowerCase().contains(name.toLowerCase()),
                () -> "Should return multiple items by part of the name"));
    }

    @DisplayName("Find multiple artists and return in order")
    @ParameterizedTest(name = "By name or part of the name {0}")
    @ValueSource(strings = {"Mary", "rs"})
    public void testFindMultipleArtistsOrderedByNameOrPartOfTheName(String name) {
        artists = artistRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);

        Set<Artist> artistsOrdered = artists.stream()
                .sorted(Comparator.comparing(a -> a.getName().toLowerCase()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        assertEquals(artists,
                artistsOrdered,
                () -> "Should return a set of artists ordered by name");
    }

    @DisplayName("Find artists ignoring case")
    @ParameterizedTest(name = "With name {0}")
    @ValueSource(strings = {"björk", "CAPITAL INICIAL"})
    public void testFindArtistsByNameIgnoringCase(String name) {
        artists = artistRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);

        artists.forEach(a ->
                assertEquals(name.toLowerCase(),
                        a.getName().toLowerCase(), () -> "Should return artist ignoring case"));
    }

    @DisplayName("Find non-existing artists")
    @ParameterizedTest(name = "With invalid name {0}")
    @ValueSource(strings = {"INVALIDNAME", "$@#%25"})
    public void testFindWithNoReturn(String name) {
        artists = artistRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);

        assertEquals(0, artists.size(), () -> "Should not return any artists");
    }

    @DisplayName("Find artists with empty parameter")
    @Test
    public void testReturnIfParameterIsEmpty() {
        artists = artistRepository.findByNameContainingIgnoreCaseOrderByNameAsc("");
        assertNotEquals(0, artists.size(), () -> "Should return all artists");
    }
}
