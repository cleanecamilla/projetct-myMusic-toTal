package com.ciandt.summit.bootcamp2022.unit;

import com.ciandt.summit.bootcamp2022.application.adapters.controllers.PlaylistController;
import com.ciandt.summit.bootcamp2022.domains.artists.Artist;
import com.ciandt.summit.bootcamp2022.domains.artists.dtos.ArtistDTO;
import com.ciandt.summit.bootcamp2022.domains.exceptions.playlists.PlaylistsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.playlists.Playlist;
import com.ciandt.summit.bootcamp2022.domains.playlists.dtos.PlaylistSongsRequestDTO;
import com.ciandt.summit.bootcamp2022.domains.playlists.ports.interfaces.PlaylistServicePort;
import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;
import com.ciandt.summit.bootcamp2022.domains.token.dto.CreateAuthorizerDTO;
import com.ciandt.summit.bootcamp2022.domains.token.dto.CreateAuthorizerDataDTO;
import com.ciandt.summit.bootcamp2022.infra.feignclients.TokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PlaylistController.class)
public class PlaylistControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TokenProvider tokenProvider;

    @MockBean
    private PlaylistServicePort playlistServicePort;

    private Playlist playlist;
    private final String USER = "user";
    private final String TOKEN = "token";
    private final String PLAYLIST_ID = "PLAYLIST_ID";
    private CreateAuthorizerDTO fakeCreateAuthorizer;
    private MockHttpServletRequestBuilder mockHttpServletRequestBuilder;
    private PlaylistSongsRequestDTO defaultPlaylistSongsRequestDTO;

    @BeforeEach
    public void setupAuthorizer() {
        CreateAuthorizerDataDTO createAuthorizerData = new CreateAuthorizerDataDTO(TOKEN, USER);
        fakeCreateAuthorizer = new CreateAuthorizerDTO(createAuthorizerData);

        Artist artist = new Artist("uuid", "artist name", new ArrayList<>());
        Song song1 = new Song("uuid", "song 1", artist);
        Song song2 = new Song("uuid", "song 2", artist);

        playlist = new Playlist("uuid", List.of(song1, song2));

        List<SongDTO> songsMappedToDTO = playlist.getSongs().stream().map(Song::toDTO).collect(Collectors.toList());
        defaultPlaylistSongsRequestDTO = new PlaylistSongsRequestDTO(songsMappedToDTO);

        mockHttpServletRequestBuilder = post("/api/playlists/{playlistId}/musicas", PLAYLIST_ID)
                .header("token", TOKEN)
                .header("user", USER)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @ParameterizedTest
    @MethodSource("songsRequestDTOGenerator")
    public void addSongsToPlaylistTest(PlaylistSongsRequestDTO playlistSongsRequestDTO) throws Exception {
        when(tokenProvider.createTokenAuthorizer(fakeCreateAuthorizer))
                .thenReturn(ResponseEntity.status(201).body("ok"));

        when(playlistServicePort.addSongsToPlaylist(PLAYLIST_ID, playlistSongsRequestDTO.getData()))
                .thenReturn(null);

        mockMvc.perform(mockHttpServletRequestBuilder.content(playlistSongsRequestDTO.toString()))
                .andExpect(status().isCreated());
    }

    @Test
    public void cannotFindPlaylistTest() throws Exception {
        when(tokenProvider.createTokenAuthorizer(fakeCreateAuthorizer))
                .thenReturn(ResponseEntity.status(201).body("ok"));


        when(playlistServicePort.addSongsToPlaylist(PLAYLIST_ID, defaultPlaylistSongsRequestDTO.getData()))
                .thenThrow(PlaylistsNotFoundException.class);

        mockMvc.perform(mockHttpServletRequestBuilder.content(defaultPlaylistSongsRequestDTO.toString()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void cannotFindSongsTest() throws Exception {
        when(tokenProvider.createTokenAuthorizer(fakeCreateAuthorizer))
                .thenReturn(ResponseEntity.status(201).body("ok"));

        when(playlistServicePort.addSongsToPlaylist(PLAYLIST_ID, defaultPlaylistSongsRequestDTO.getData()))
                .thenThrow(new SongsNotFoundException("Specified song was not found."));

        mockMvc.perform(mockHttpServletRequestBuilder.content(defaultPlaylistSongsRequestDTO.toString()))
                .andExpect(status().isBadRequest());
    }

    private static List<PlaylistSongsRequestDTO> songsRequestDTOGenerator() {
        ArtistDTO artistDTO = new ArtistDTO("uuid", "artist name");
        SongDTO songDTO1 = new SongDTO("uuid", "song 1", artistDTO);
        SongDTO songDTO2 = new SongDTO("uuid", "song 2", artistDTO);

        return List.of(new PlaylistSongsRequestDTO(List.of()), new PlaylistSongsRequestDTO(List.of(songDTO1, songDTO2)));
    }
}
