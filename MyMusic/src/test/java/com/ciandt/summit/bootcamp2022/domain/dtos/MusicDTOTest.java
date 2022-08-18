package com.ciandt.summit.bootcamp2022.domain.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

public class MusicDTOTest {

    private MusicDTO musicDTO;
    private UUID id;
    private UUID artistId;
    private UUID wrongId;
    private UUID wrongArtistId;

    @BeforeEach
    void setup() {
        id = UUID.randomUUID();
        artistId = UUID.randomUUID();
        wrongId = UUID.randomUUID();
        wrongArtistId = UUID.randomUUID();
    }

    @Test
    void musicDTOGettersTest() {
        musicDTO = new MusicDTO(id, "Maracatu atomico", artistId);

        assertEquals(id, musicDTO.getId());
        assertEquals("Maracatu atomico", musicDTO.getName());
        assertEquals(artistId, musicDTO.getArtistId());

        assertNotEquals(wrongId, musicDTO.getId());
        assertNotEquals("Risoflora", musicDTO.getName());
        assertNotEquals(wrongArtistId, musicDTO.getArtistId());
    }


}
