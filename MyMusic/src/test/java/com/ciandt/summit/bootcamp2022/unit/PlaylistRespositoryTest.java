package com.ciandt.summit.bootcamp2022.unit;

import com.ciandt.summit.bootcamp2022.SummitBootcampApplication;
import com.ciandt.summit.bootcamp2022.domains.playlists.Playlist;
import com.ciandt.summit.bootcamp2022.domains.playlists.ports.repositories.PlaylistRespositoryPort;
import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.PlaylistEntity;
import com.ciandt.summit.bootcamp2022.infra.adapters.repositories.SpringPlaylistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SummitBootcampApplication.class)
public class PlaylistRespositoryTest {
    @MockBean
    private SpringPlaylistRepository springPlaylistRepository;

    @Autowired
    private PlaylistRespositoryPort playlistRespositoryPort;
    private final String ID = "jhjh1222";
    private Playlist playlist;
    private PlaylistEntity playlistEntity;

    private Song song;
    @BeforeEach
    public void setup() {
        playlist = new Playlist();
        playlistEntity = new PlaylistEntity();
        song = new Song();
    }

    @Test
    public void PlaylistFound() {
        when(springPlaylistRepository.findById(ID))
                .thenReturn(Optional.of(playlistEntity));
        Optional<PlaylistEntity> result = assertDoesNotThrow(() -> playlistRespositoryPort.findById(ID));

        assertTrue(result.isPresent());
    }
    @Test
    public void PlaylistNotFound() {
        when(springPlaylistRepository.findById(ID))
                .thenReturn(Optional.empty());
        Optional<PlaylistEntity> result = playlistRespositoryPort.findById(ID);

        assertFalse(result.isPresent());
    }
}
