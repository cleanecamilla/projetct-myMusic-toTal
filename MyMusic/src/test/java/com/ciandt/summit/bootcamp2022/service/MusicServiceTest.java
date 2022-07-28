package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.entity.Music;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MusicServiceTest {

    @Autowired
    private MusicServiceImpl musicService;


    @DisplayName(value = "Valid Parameter")
    @ParameterizedTest(name = "Parameter with more than two characters {0}")
    @ValueSource(strings = {"hi", "Us", "HIGHER", "Sweet Child O' Mine"})
    public void testIfIsAValidParameter(String filter) {

        Boolean functionReturn = musicService.isAValidSearch(filter);
        assertTrue( functionReturn);

    }

    @DisplayName(value = "Invalid Parameter")
    @ParameterizedTest(name = "Parameter with less than two characters {0}")
    @ValueSource(strings = {"A", "a", " ", ""})
    public void testIfIsNotAValidParameter(String filter) {

        Boolean functionReturn = musicService.isAValidSearch(filter);
        Assertions.assertFalse(functionReturn);

    }


    @DisplayName(value = "Search music by name.")
    @ParameterizedTest(name = "Necessary to search the music by name {0}")
    @ValueSource(strings = {"HIPPY HIPPY SHAKE", "reminiscing", "How Beatlemania Began", "I Cry Instead"})
    public void testFindMusicByNome(String filter) {

        Set<Music> musics = musicService.searchMusicByName(filter);

        musics.forEach(m -> {
            assertEquals(m.getName().toLowerCase().contains(filter),
                    m.getName().toLowerCase(), () -> "Should return music ignoring case");
        });

    }


    @DisplayName(value = "Search music by name not successfully.")
    @ParameterizedTest(name = "When not found music, return an array empty {0}")
    @ValueSource(strings = {"Drink Wine", " ", "", "Eyes of the Tiger"})
    public void testNotFindMusicByNome(String filter) {

        Set<Music> musics = musicService.searchMusicByName(filter);

        musics.forEach(m -> {
            assertEquals(m.getName().toLowerCase().contains(filter),
                    m.getName().toLowerCase(), () -> "Should return an array empty");
        });
    }

   /* @DisplayName(value = "Return of all musics founded matching filter, ordered by Artist and Music.")
    @ParameterizedTest(name = "Return an ordered list {0}")
    @ValueSource(strings = {"hi", "Us", "HIGHER", "Sweet Child O' Mine"})
    public void testFindAllMusicsByNome(String filter) {

        Map<Artist, Set<Music>> musics = musicService.searchMusicsByFilter(filter);

        Map<Artist, Set<Music>> musicsOrdered = musics.stream()
                .sorted(Comparator.comparing(a -> a.getName().toLowerCase()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        assertEquals(musicsOrdered, musics);

    }*/

















}