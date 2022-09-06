package com.ciandt.summit.bootcamp2022.domain;


import com.ciandt.summit.bootcamp2022.domain.dtos.ArtistDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArtistTest {

    private Artist artist;

    @BeforeEach
    void setup() {
        artist = new Artist();
    }

    @Test
    void artistGettersSettersTest() {
        artist.setId("32844fdd-bb76-4c0a-9627-e34ddc9fd892");
        artist.setName("Alceu");

        assertEquals("32844fdd-bb76-4c0a-9627-e34ddc9fd892", artist.getId());
        assertEquals("Alceu", artist.getName());

        assertNotEquals("efb6b534-3434-4d4e-b70c-a7bfe76e53cc", artist.getId());
        assertNotEquals("Gonzaga", artist.getName());
    }

    @Test
    void artistCreatedFromArtistDTOTest() {
        ArtistDTO artistDTO = new ArtistDTO("32844fdd-bb76-4c0a-9627-e34ddc9fd892", "Lenine");

        artist = new Artist(artistDTO);

        assertEquals("32844fdd-bb76-4c0a-9627-e34ddc9fd892", artist.getId());
        assertEquals("Lenine", artist.getName());

        assertNotEquals("efb6b534-3434-4d4e-b70c-a7bfe76e53cc", artist.getId());
        assertNotEquals("Chico", artist.getName());
    }

    @Test
    void artistTurnedIntoArtistDTOTest() {
        artist.setId("32844fdd-bb76-4c0a-9627-e34ddc9fd892");
        artist.setName("Ramalho");

        ArtistDTO artistDTO = artist.toArtistDTO();

        assertEquals(artistDTO.getId(), artist.getId());
        assertEquals(artistDTO.getName(), artist.getName());

        assertNotEquals("efb6b534-3434-4d4e-b70c-a7bfe76e53cc", artist.getId());
        assertNotEquals("Cesar", artist.getName());
    }
}
