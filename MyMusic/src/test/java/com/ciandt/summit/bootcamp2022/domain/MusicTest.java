package com.ciandt.summit.bootcamp2022.domain;

import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MusicTest {

    private Music music;

    @BeforeEach
    void setup() {
        music = new Music();
    }

    /*@Test
    void musicGettersSettersTest() {
        music.setId("67f5976c-eb1e-404e-8220-2c2a8a23be47");
        music.setName("Asa Branca");
        music.setArtistId("32844fdd-bb76-4c0a-9627-e34ddc9fd892");

        assertEquals("67f5976c-eb1e-404e-8220-2c2a8a23be47", music.getId());
        assertEquals("Asa Branca", music.getName());
        assertEquals("32844fdd-bb76-4c0a-9627-e34ddc9fd892", music.getArtistId());


        assertNotEquals("6ec77cba-4842-4ecd-9775-c75ba96694e2", music.getId());
        assertNotEquals("Maluco Beleza", music.getName());
        assertNotEquals("efb6b534-3434-4d4e-b70c-a7bfe76e53cc", music.getArtistId());
    }

    @Test
    void musicCreatedFromDTOTest() {
        MusicDTO musicDTO = new MusicDTO(
                "67f5976c-eb1e-404e-8220-2c2a8a23be47",
                "La belle de jour",
                "32844fdd-bb76-4c0a-9627-e34ddc9fd892");

        music = new Music(musicDTO);

        assertEquals("67f5976c-eb1e-404e-8220-2c2a8a23be47", music.getId());
        assertEquals("La belle de jour", music.getName());
        assertEquals("32844fdd-bb76-4c0a-9627-e34ddc9fd892", music.getArtistId());

        assertNotEquals("6ec77cba-4842-4ecd-9775-c75ba96694e2", music.getId());
        assertNotEquals("Maluco Beleza", music.getName());
        assertNotEquals("efb6b534-3434-4d4e-b70c-a7bfe76e53cc", music.getArtistId());
    }

    @Test
    void musicTurnedIntoMusicDTOTest() {
        music.setId("67f5976c-eb1e-404e-8220-2c2a8a23be47");
        music.setName("Leao do norte");
        music.setArtistId("32844fdd-bb76-4c0a-9627-e34ddc9fd892");

        MusicDTO musicDTO = music.toMusicDTO();

        assertEquals(musicDTO.getId(), music.getId());
        assertEquals(musicDTO.getName(), music.getName());
        assertEquals(musicDTO.getArtistId(), music.getArtistId());

        assertNotEquals("6ec77cba-4842-4ecd-9775-c75ba96694e2", music.getId());
        assertNotEquals("Maluco Beleza", music.getName());
        assertNotEquals("efb6b534-3434-4d4e-b70c-a7bfe76e53cc", music.getArtistId());
    }*/
}
