package com.ciandt.summit.bootcamp2022.domain.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

public class ArtistDTOTest {

    private ArtistDTO artistDTO;
    private UUID id;
    private UUID wrongId;

    @BeforeEach
    void setup() {
        id = UUID.randomUUID();
        wrongId = UUID.randomUUID();
    }

    @Test
    void artistDTOGettersTest() {
        artistDTO = new ArtistDTO(id, "Chico");

        assertEquals(id, artistDTO.getId());
        assertEquals("Chico", artistDTO.getName());

        assertNotEquals(wrongId, artistDTO.getId());
        assertNotEquals("Lia", artistDTO.getName());
    }
}
