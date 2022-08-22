package com.ciandt.summit.bootcamp2022.unit;

import com.ciandt.summit.bootcamp2022.SummitBootcampApplication;
import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.repositories.SongRepositoryPort;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.ArtistEntity;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.SongEntity;
import com.ciandt.summit.bootcamp2022.infra.adapters.repositories.SpringSongRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SummitBootcampApplication.class)
public class SongRepositoryTest {
    @MockBean
    private SpringSongRepository springSongRepository;

    @Autowired
    private SongRepositoryPort songRepositoryPort;

    private int pageSize = 10;
    private String filter = "Song Mocked";
    private List<SongEntity> songEntities = new ArrayList<>();

    @BeforeEach
    public void setup () {
        ArtistEntity artistEntity = new ArtistEntity("Fake Artist");

        for (int i = 0; i < 20; i++) {
            songEntities.add(new SongEntity(filter + " " + (i + 1), artistEntity));
        }
    }

    @Test
    public void findFirstSongsPage() {
        Pageable pageable = Pageable.ofSize(pageSize).withPage(0);
        when(springSongRepository.findByNameOrArtistName(filter, pageable))
                .thenReturn(new PageImpl<>(songEntities.subList(0, pageSize)));

        List<Song> songs = songRepositoryPort.findByNameOrArtistName(filter, 0);
        boolean hasAnySongsOfSecondPage = songs.stream().anyMatch(s -> {
            int songMockCode = Integer.parseInt(s.getName().substring(12));

            return songMockCode > 10;
        });

        assertEquals(songs.size(), 10);
        assertFalse(hasAnySongsOfSecondPage);
    }

    @Test
    public void findSecondSongsPage() {
        Pageable pageable = Pageable.ofSize(pageSize).withPage(1);
        when(springSongRepository.findByNameOrArtistName(filter, pageable))
                .thenReturn(new PageImpl<>(songEntities.subList(pageSize, pageSize * 2)));

        List<Song> songs = songRepositoryPort.findByNameOrArtistName(filter, 1);
        boolean hasOnlySongsOfSecondPage = songs.stream().allMatch(s -> {
            int songMockCode = Integer.parseInt(s.getName().substring(12));

            return songMockCode > 10;
        });

        assertEquals(songs.size(), 10);
        assertFalse(hasOnlySongsOfSecondPage);
    }

    @Test
    public void noSongsFounded() {
        Pageable pageable = Pageable.ofSize(pageSize).withPage(0);
        when(springSongRepository.findByNameOrArtistName("NOT FOUND", pageable))
                .thenReturn(Page.empty());

        List<Song> songs = assertDoesNotThrow(() -> songRepositoryPort.findByNameOrArtistName(filter, 0));
        assertTrue(songs.isEmpty());
    }
}
