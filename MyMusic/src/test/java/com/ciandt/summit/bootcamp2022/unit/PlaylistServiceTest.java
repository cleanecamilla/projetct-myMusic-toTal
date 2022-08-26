package com.ciandt.summit.bootcamp2022.unit;

import com.ciandt.summit.bootcamp2022.SummitBootcampApplication;
import com.ciandt.summit.bootcamp2022.domains.artists.Artist;
import com.ciandt.summit.bootcamp2022.domains.exceptions.playlists.PlaylistsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.playlists.Playlist;
import com.ciandt.summit.bootcamp2022.domains.playlists.ports.interfaces.PlaylistServicePort;
import com.ciandt.summit.bootcamp2022.domains.playlists.ports.repositories.PlaylistRespositoryPort;
import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.repositories.SongRepositoryPort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SummitBootcampApplication.class)
public class PlaylistServiceTest {
    @MockBean
    private PlaylistRespositoryPort playlistRespositoryPort;
    @MockBean
    private SongRepositoryPort songRepositoryPort;

    @Autowired
    private PlaylistServicePort playlistServicePort;

    private final static List<Song> SONGS_FROM_REPO = new ArrayList<>();
    private final static List<Playlist> PLAYLISTS_FROM_REPO = new ArrayList<>();

    @BeforeAll
    static void setup(){
        Artist artist = new Artist(UUID.randomUUID().toString(), "Fake Artist", new ArrayList<>());

        List.of("About A Girl", "About A Boy", "About A Dog").forEach(name -> {
            Song song = new Song(UUID.randomUUID().toString(), name, artist);
            SONGS_FROM_REPO.add(song);
        });

        List<Song> playlistSongs = new ArrayList<>(SONGS_FROM_REPO);

        Playlist playlist = new Playlist(UUID.randomUUID().toString(), playlistSongs);
        PLAYLISTS_FROM_REPO.add(playlist);

        for(int i = 0; i < 7; i++){
            Song song = new Song(UUID.randomUUID().toString(), "Fake Song " + 1 + i, artist);
            SONGS_FROM_REPO.add(song);
        }

        for(int i = 0; i < 4; i++){
            playlist = new Playlist(UUID.randomUUID().toString(), new ArrayList<>());
            PLAYLISTS_FROM_REPO.add(playlist);
        }
    }

    @Test
    void addSongsToPlaylistPassingValidListOfSongs() throws PlaylistsNotFoundException, SongsNotFoundException {
        String id = PLAYLISTS_FROM_REPO.get(2).getId();
        List<SongDTO> songs = new ArrayList<>();
        songs.add(SONGS_FROM_REPO.get(0).toDTO());
        songs.add(SONGS_FROM_REPO.get(1).toDTO());
        songs.add(SONGS_FROM_REPO.get(2).toDTO());

        when(playlistRespositoryPort.findById(id)).thenReturn(PLAYLISTS_FROM_REPO.get(2));
        when(songRepositoryPort.findById(SONGS_FROM_REPO.get(0).getId())).thenReturn(SONGS_FROM_REPO.get(0));
        when(songRepositoryPort.findById(SONGS_FROM_REPO.get(1).getId())).thenReturn(SONGS_FROM_REPO.get(1));
        when(songRepositoryPort.findById(SONGS_FROM_REPO.get(2).getId())).thenReturn(SONGS_FROM_REPO.get(2));

        playlistServicePort.addSongsToPlaylist(id, songs);

        Playlist playlist = playlistRespositoryPort.findById(id);

        assertEquals(3, playlist.getSongs().size());
    }

    @Test
    void addSongsToPlaylistPassingInvalidListOfSongs() throws PlaylistsNotFoundException, SongsNotFoundException {
        String id = PLAYLISTS_FROM_REPO.get(1).getId();
        List<SongDTO> songs = new ArrayList<>();
        songs.add(SONGS_FROM_REPO.get(1).toDTO());
        Song song = new Song(UUID.randomUUID().toString(), "name", new Artist(UUID.randomUUID().toString(), "Fake Artist 2", new ArrayList<>()));
        songs.add(song.toDTO());

        when(playlistRespositoryPort.findById(id)).thenReturn(PLAYLISTS_FROM_REPO.get(1));
        when(songRepositoryPort.findById(SONGS_FROM_REPO.get(1).getId())).thenReturn(SONGS_FROM_REPO.get(1));
        when(songRepositoryPort.findById(song.getId())).thenThrow(new SongsNotFoundException("Specified song was not found."));


        SongsNotFoundException thrown = assertThrows(SongsNotFoundException.class, () -> {
            playlistServicePort.addSongsToPlaylist(id, songs);
        });

        assertEquals("Specified song was not found.", thrown.getMessage());
    }

    @Test
    void addSongsToNonExistentPlaylist() throws SongsNotFoundException, PlaylistsNotFoundException {
        String id = "NOT FOUND";
        List<SongDTO> songs = new ArrayList<>();

        when(playlistRespositoryPort.findById(id)).thenThrow(new PlaylistsNotFoundException("Specified playlist was not found"));

        PlaylistsNotFoundException thrown = assertThrows(PlaylistsNotFoundException.class, () -> {
            playlistServicePort.addSongsToPlaylist(id, songs);
        });

        assertEquals("Specified playlist was not found", thrown.getMessage());
    }
}
