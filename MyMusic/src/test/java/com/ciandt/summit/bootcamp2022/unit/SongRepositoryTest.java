package com.ciandt.summit.bootcamp2022.unit;

import com.ciandt.summit.bootcamp2022.SummitBootcampApplication;
import com.ciandt.summit.bootcamp2022.domains.songs.SongsPaginated;
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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SummitBootcampApplication.class)
public class SongRepositoryTest {
    @MockBean
    private SpringSongRepository springSongRepository;

    @Autowired
    private SongRepositoryPort songRepositoryPort;

    private final int PAGE_SIZE = 10;
    private final String FILTER = "Song Mocked";
    private final List<SongEntity> SONG_ENTITIES = new ArrayList<>();

    private int extractSongMockCode(String songMockName) {
        return Integer.parseInt(songMockName.substring(12));
    }

    @BeforeEach
    public void setup () {
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setName("Fake Artist");

        for (int i = 0; i < 20; i++) {
            SongEntity songEntity = new SongEntity();
            songEntity.setName(FILTER + " " + (i + 1));
            songEntity.setArtist(artistEntity);

            SONG_ENTITIES.add(songEntity);
        }
    }

    @Test
    public void findFirstSongsPage() {
        Pageable pageable = Pageable.ofSize(PAGE_SIZE).withPage(0);
        when(springSongRepository.findByNameOrArtistName(FILTER, pageable))
                .thenReturn(new PageImpl<>(SONG_ENTITIES.subList(0, PAGE_SIZE)));

        SongsPaginated songsPaginated = songRepositoryPort.findByNameOrArtistName(FILTER, 0);
        boolean hasAnySongsOfSecondPage = songsPaginated.getData().stream().allMatch(s -> extractSongMockCode(s.getName()) <= 10);

        assertEquals(songsPaginated.getData().size(), 10);
        assertTrue(hasAnySongsOfSecondPage);
    }

    @Test
    public void findSecondSongsPage() {
        Pageable pageable = Pageable.ofSize(PAGE_SIZE).withPage(1);
        when(springSongRepository.findByNameOrArtistName(FILTER, pageable))
                .thenReturn(new PageImpl<>(SONG_ENTITIES.subList(PAGE_SIZE, PAGE_SIZE * 2)));

        SongsPaginated songsPaginated = songRepositoryPort.findByNameOrArtistName(FILTER, 1);
        boolean hasOnlySongsOfSecondPage = songsPaginated.getData().stream().allMatch(s -> extractSongMockCode(s.getName()) > 10);

        assertTrue(hasOnlySongsOfSecondPage);
        assertEquals(songsPaginated.getData().size(), 10);
        assertEquals(songsPaginated.getTotalElements(), 10);
        assertEquals(songsPaginated.getROWS_PER_PAGE(), 10);
    }

    @Test
    public void noSongsFound() {
        Pageable pageable = Pageable.ofSize(PAGE_SIZE).withPage(0);
        when(springSongRepository.findByNameOrArtistName("NOT FOUND", pageable))
                .thenReturn(new PageImpl<>(new ArrayList<>()));

        SongsPaginated songsPaginated = assertDoesNotThrow(() -> songRepositoryPort.findByNameOrArtistName("NOT FOUND", 0));

        assertTrue(songsPaginated.getData().isEmpty());
        assertEquals(songsPaginated.getTotalElements(), 0);
    }
}
