package com.ciandt.summit.bootcamp2022.domain.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ArtistDTOTest {

    private ArtistDTO artistDTO;

    @Test
    void artistDTOGettersTest() {
        artistDTO = new ArtistDTO("32844fdd-bb76-4c0a-9627-e34ddc9fd892", "Chico");

        assertEquals("32844fdd-bb76-4c0a-9627-e34ddc9fd892", artistDTO.getId());
        assertEquals("Chico", artistDTO.getName());

        assertNotEquals("efb6b534-3434-4d4e-b70c-a7bfe76e53cc", artistDTO.getId());
        assertNotEquals("Lia", artistDTO.getName());
    }
}
