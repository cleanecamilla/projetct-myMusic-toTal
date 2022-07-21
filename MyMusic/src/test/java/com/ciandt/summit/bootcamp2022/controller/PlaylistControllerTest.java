package com.ciandt.summit.bootcamp2022.controller;

import com.ciandt.summit.bootcamp2022.controller.request.PlaylistRequest;
import com.ciandt.summit.bootcamp2022.entity.Artista;
import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.entity.Playlist;
import com.ciandt.summit.bootcamp2022.service.PlaylistServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PlaylistControllerTest {

    @Mock
    PlaylistServiceImp playlistServiceImp;

    @Autowired
    private MockMvc mvc;

    @Test
    void test_adicionarMusica() throws Exception {

        Musica musica = new Musica();
        musica.setId("4ffb5d4f-8b7f-4996-b84b-ecf751f52eea");
        musica.setNome("B.B. On Mars");

        Artista artista = new Artista();
        artista.setId("30ab1678-c616-4314-adcc-918aff5a7a13");
        artista.setNome("Alice Cooper");
        musica.setArtista(artista);

        Playlist playlist = new Playlist();
        playlist.setId("cb746719-b60e-4c38-9976-f2cbc68581cb");

        playlist.setMusicas(new ArrayList<>(List.of(musica)));

        PlaylistRequest pr = new PlaylistRequest(musica);

        given(playlistServiceImp.adicionarMusicaNaPlaylist(
                "cb746719-b60e-4c38-9976-f2cbc68581cb", pr)).willReturn(playlist);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(pr);

        RequestBuilder request = post("/api/playlists/cb746719-b60e-4c38-9976-f2cbc68581cb/musicas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson);

        MvcResult result = mvc.perform(request).andExpect(status().isCreated()).andReturn();

        assertEquals("",
                result.getResponse().getContentAsString());

    }

}