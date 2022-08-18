package com.ciandt.summit.bootcamp2022.domain;

import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

public class MusicTest {

    private Music music;
    private UUID id;
    private UUID artistId;

    private UUID wrongId;

    private UUID wrongArtistId;

    @BeforeEach
    void setup() {
        music = new Music();
        id = UUID.randomUUID();
        artistId = UUID.randomUUID();
        wrongId = UUID.randomUUID();
        wrongArtistId = UUID.randomUUID();
    }

    @Test
    void musicGettersSettersTest() {
        music.setId(id);
        music.setName("Asa Branca");
        music.setArtistId(artistId);

        assertEquals(id, music.getId());
        assertEquals("Asa Branca", music.getName());
        assertEquals(artistId, music.getArtistId());


        assertNotEquals(wrongId, music.getId());
        assertNotEquals("Maluco Beleza", music.getName());
        assertNotEquals(wrongArtistId, music.getArtistId());
    }

    @Test
    void musicCreatedFromDTOTest() {
        MusicDTO musicDTO = new MusicDTO(id, "La belle de jour", artistId);

        music = new Music(musicDTO);

        assertEquals(id, music.getId());
        assertEquals("La belle de jour", music.getName());
        assertEquals(artistId, music.getArtistId());

        assertNotEquals(wrongId, music.getId());
        assertNotEquals("Maluco Beleza", music.getName());
        assertNotEquals(wrongArtistId, music.getArtistId());
    }

    @Test
    void musicTurnedIntoMusicDTOTest() {
        music.setId(id);
        music.setName("Leao do norte");
        music.setArtistId(artistId);

        MusicDTO musicDTO = music.toMusicDTO();

        assertEquals(musicDTO.getId(), music.getId());
        assertEquals(musicDTO.getName(), music.getName());
        assertEquals(musicDTO.getArtistId(), music.getArtistId());

        assertNotEquals(wrongId, music.getId());
        assertNotEquals("Maluco Beleza", music.getName());
        assertNotEquals(wrongArtistId, music.getArtistId());
    }
}
