package com.ciandt.summit.bootcamp2022.domain;


import com.ciandt.summit.bootcamp2022.domain.dtos.ArtistDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

public class ArtistTest {

    private Artist artist;
    private UUID id;
    private UUID wrongId;

    @BeforeEach
    void setup() {
        artist = new Artist();
        id = UUID.randomUUID();
        wrongId = UUID.randomUUID();
    }

    @Test
    void artistGettersSettersTest() {
        artist.setId(id);
        artist.setName("Alceu");

        assertEquals(id, artist.getId());
        assertEquals("Alceu", artist.getName());

        assertNotEquals(wrongId, artist.getId());
        assertNotEquals("Gonzaga", artist.getName());
    }

    @Test
    void artistCreatedFromArtistDTOTest() {
        ArtistDTO artistDTO = new ArtistDTO(id, "Lenine");

        artist = new Artist(artistDTO);

        assertEquals(id, artist.getId());
        assertEquals("Lenine", artist.getName());

        assertNotEquals(wrongId, artist.getId());
        assertNotEquals("Chico", artist.getName());
    }

    @Test
    void artistTurnedIntoArtistDTOTest() {
        artist.setId(id);
        artist.setName("Ramalho");

        ArtistDTO artistDTO = artist.toArtistDTO();

        assertEquals(artistDTO.getId(), artist.getId());
        assertEquals(artistDTO.getName(), artist.getName());

        assertNotEquals(wrongId, artist.getId());
        assertNotEquals("Cesar", artist.getName());
    }
}
