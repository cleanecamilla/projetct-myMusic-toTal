package com.ciandt.summit.bootcamp2022.integration.repositories;

import com.ciandt.summit.bootcamp2022.SummitBootcampApplication;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.SongEntity;
import com.ciandt.summit.bootcamp2022.infra.adapters.repositories.SpringSongRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SummitBootcampApplication.class)
public class SpringSongRepositoryTest {

    @Autowired
    SpringSongRepository springSongRepository;

    @Test
    public void findPaginatedSons() {
        Page<SongEntity> result = springSongRepository.findByNameOrArtistName("The", Pageable.ofSize(10));

        assertFalse(result.isEmpty());
        assertEquals(result.getNumberOfElements(), 10);
    }

    @Test
    public void findSongsByNameWithArtist() {
        Page<SongEntity> result = springSongRepository.findByNameOrArtistName("The", Pageable.ofSize(10));

        SongEntity firstSongEntity = result.stream().findFirst().get();
        boolean allSongsStartsWithFilter = result.stream().allMatch(s -> s.getName().startsWith("The"));

        assertTrue(allSongsStartsWithFilter);
        assertNotNull(firstSongEntity.getArtist());
    }

    @Test
    public void findSongsByArtistName() {
        Page<SongEntity> result = springSongRepository.findByNameOrArtistName("R.E.M.", Pageable.ofSize(10));

        boolean allSongsNotStartsWithFilter = result.stream().noneMatch(s -> s.getName().startsWith("R.E.M."));
        boolean allArtistsIsREM = result.stream().allMatch(s -> s.getArtist().getName().equalsIgnoreCase("R.E.M."));

        assertFalse(result.isEmpty());
        assertTrue(allSongsNotStartsWithFilter);
        assertTrue(allArtistsIsREM);
    }
}
