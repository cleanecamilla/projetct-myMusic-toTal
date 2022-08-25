package com.ciandt.summit.bootcamp2022.unit;

import com.ciandt.summit.bootcamp2022.application.adapters.controllers.SongsController;
import com.ciandt.summit.bootcamp2022.domains.artists.dtos.ArtistDTO;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.InvalidSongNameOrArtistNameException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.interfaces.SongServicePort;
import com.ciandt.summit.bootcamp2022.domains.token.dto.CreateAuthorizerDTO;
import com.ciandt.summit.bootcamp2022.domains.token.dto.CreateAuthorizerDataDTO;
import com.ciandt.summit.bootcamp2022.infra.feignclients.TokenProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SongsController.class)
public class SongsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TokenProvider tokenProvider;

    @MockBean
    private SongServicePort songServicePort;

    private final String TOKEN = "token";
    private final String USER = "user";

    private CreateAuthorizerDTO fakeCreateAuthorizer;

    private static final List<SongDTO> SONGS_FROM_SERVICE = new ArrayList<>();

    private final int PAGE_SIZE = 10;

    @BeforeAll
    static void setup(){
        ArtistDTO artistDTO = new ArtistDTO(UUID.randomUUID().toString(), "Fake Artist");

        List.of("About A Girl", "About A Boy", "About A Dog").forEach(name -> {
            SongDTO song = new SongDTO(UUID.randomUUID().toString(), name, artistDTO);
            SONGS_FROM_SERVICE.add(song);
        });

        for(int i = 0; i < 7; i++){
            SongDTO song = new SongDTO(UUID.randomUUID().toString(), "Fake Song " + 1 + i, artistDTO);
            SONGS_FROM_SERVICE.add(song);
        }
    }

    @BeforeEach
    public void setupAuthorizer() {
        CreateAuthorizerDataDTO createAuthorizerData = new CreateAuthorizerDataDTO(TOKEN, USER);
        fakeCreateAuthorizer = new CreateAuthorizerDTO(createAuthorizerData);
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"A"})
    public void callFindSongsEndpointPassingInvalidParametersReturnsBadRequest(String parameter) throws Exception {
        when(songServicePort.findByNameOrArtistName(parameter, PAGE_SIZE))
                .thenThrow(InvalidSongNameOrArtistNameException.class);

        List<SongDTO> expected = List.of();

        when(tokenProvider.createTokenAuthorizer(fakeCreateAuthorizer))
                .thenReturn(ResponseEntity.status(201).body("ok"));

        MvcResult response = mockMvc
                .perform(get("/api/musicas")
                        .header("token", TOKEN)
                        .header("user", USER)
                        .param("filtro", parameter)).andReturn();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getResponse().getStatus());

    }

    @Test
    public void callFindSongsEndpointPassingValidParameterReturnsNotFound() throws Exception {
        String parameter = "NOT_FOUND";

        when(songServicePort.findByNameOrArtistName(parameter, PAGE_SIZE))
                .thenThrow(SongsNotFoundException.class);

        when(tokenProvider.createTokenAuthorizer(fakeCreateAuthorizer))
                .thenReturn(ResponseEntity.status(201).body("ok"));

        MockHttpServletResponse response = mockMvc
                .perform(get("/api/musicas")
                        .header("token", TOKEN)
                        .header("user", USER)
                        .param("filtro", parameter)).andReturn().getResponse();

        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
        assertEquals("[]", response.getContentAsString());
    }

    @Test
    public void callFindSongsEndpointPassingValidParameterRelatedToSong() throws Exception {
        String parameter = "About";

        when(songServicePort.findByNameOrArtistName(parameter, PAGE_SIZE))
                .thenReturn(new ArrayList<>(SONGS_FROM_SERVICE.subList(0, 3)));

        when(tokenProvider.createTokenAuthorizer(fakeCreateAuthorizer))
                .thenReturn(ResponseEntity.status(201).body("ok"));

        MockHttpServletResponse response = mockMvc
                .perform(get("/api/musicas")
                        .header("token", TOKEN)
                        .header("user", USER)
                        .param("filtro", parameter)).andReturn().getResponse();

        String responseContent = response.getContentAsString().replaceAll(" ", "");
        String expectedContent = SONGS_FROM_SERVICE.subList(0, 3).toString().replaceAll(" ", "");

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(expectedContent, responseContent);
    }

    @Test
    public void callFindSongsEndpointPassingValidParameterRelatedToArtist() throws Exception {
        String parameter = "Artist";

        when(songServicePort.findByNameOrArtistName(parameter, PAGE_SIZE))
                .thenReturn(new ArrayList<>(SONGS_FROM_SERVICE.subList(0, 10)));

        when(tokenProvider.createTokenAuthorizer(fakeCreateAuthorizer))
                .thenReturn(ResponseEntity.status(201).body("ok"));

        MockHttpServletResponse response = mockMvc
                .perform(get("/api/musicas")
                        .header("token", TOKEN)
                        .header("user", USER)
                        .param("filtro", parameter)).andReturn().getResponse();

        String responseContent = response.getContentAsString().replaceAll(" ", "");
        String expectedContent = SONGS_FROM_SERVICE.toString().replaceAll(" ", "");

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(expectedContent, responseContent);
    }
}
