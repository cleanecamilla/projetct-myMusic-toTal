package com.ciandt.summit.bootcamp2022.unit;

import com.ciandt.summit.bootcamp2022.SummitBootcampApplication;
import com.ciandt.summit.bootcamp2022.domains.artists.Artist;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.InvalidSongNameOrArtistNameException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.interfaces.SongServicePort;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.repositories.SongRepositoryPort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SummitBootcampApplication.class)
public class SongServiceTest {

    @MockBean
    private SongRepositoryPort songRepositoryPort;

    @Autowired
    private SongServicePort songServicePort;

    private final int PAGE_SIZE = 10;

    private final static List<Song> SONGS_FROM_REPO = new ArrayList<>();

    @BeforeAll
    static void setup(){
        Artist artist = new Artist(UUID.randomUUID().toString(), "Fake Artist", new ArrayList<>());

        List.of("About A Girl", "About A Boy", "About A Dog").forEach(name -> {
            Song song = new Song(UUID.randomUUID().toString(), name, artist);
            SONGS_FROM_REPO.add(song);
        });

        for(int i = 0; i < 7; i++){
            Song song = new Song(UUID.randomUUID().toString(), "Fake Song " + 1 + i, artist);
            SONGS_FROM_REPO.add(song);
        }
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"A"})
    public void findSongsPassingInvalidParametersThrowsInvalidNameException(String parameter){
        InvalidSongNameOrArtistNameException thrown = assertThrows(InvalidSongNameOrArtistNameException.class, () -> {
            songServicePort.findByNameOrArtistName(parameter, PAGE_SIZE);
        });

        assertEquals("Filter must be at least 2 characters long.", thrown.getMessage());
    }

    @Test
    public void findSongsPassingValidParameterThrowsNotFoundException(){
        String parameter = "NOT_FOUND";
        SongsNotFoundException thrown = assertThrows(SongsNotFoundException.class, () -> {
            songServicePort.findByNameOrArtistName(parameter, 10);
        });

        assertEquals("No songs were found.", thrown.getMessage());
    }

    @Test
    public void findSongsPassingValidParameterRelatedToSongName()
            throws SongsNotFoundException, InvalidSongNameOrArtistNameException {
        String parameter = "About";
        when(songRepositoryPort.findByNameOrArtistName(parameter, PAGE_SIZE))
                .thenReturn(new ArrayList<>(SONGS_FROM_REPO.subList(0, 3)));

        List<SongDTO> songs = songServicePort.findByNameOrArtistName(parameter, PAGE_SIZE);
        boolean returnedSongsContainParameterInName = songs.stream().allMatch(s -> s.getName().contains(parameter));

        assertTrue(returnedSongsContainParameterInName);
        assertEquals(3, songs.size());
    }

    @Test
    public void findSongsPassingValidParameterRelatedToArtistName()
            throws SongsNotFoundException, InvalidSongNameOrArtistNameException {
        String parameter = "Artist";
        when(songRepositoryPort.findByNameOrArtistName(parameter, PAGE_SIZE))
                .thenReturn(new ArrayList<>(SONGS_FROM_REPO.subList(0, PAGE_SIZE)));

        List<SongDTO> songs = songServicePort.findByNameOrArtistName(parameter, PAGE_SIZE);
        boolean returnedSongsContainParameterInName = songs.stream().allMatch(s ->
                s.getArtist().getName().contains(parameter));

        assertTrue(returnedSongsContainParameterInName);
        assertEquals(10, songs.size());
    }

}
