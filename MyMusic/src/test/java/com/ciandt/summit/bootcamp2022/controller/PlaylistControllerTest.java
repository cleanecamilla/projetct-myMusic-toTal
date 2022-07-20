package com.ciandt.summit.bootcamp2022.controller;


import com.ciandt.summit.bootcamp2022.config.interceptor.JwtInterceptor;
import com.ciandt.summit.bootcamp2022.controller.dto.MusicaDto;
import com.ciandt.summit.bootcamp2022.entity.Artista;
import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.service.PlayListService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Import(PlaylistController.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PlaylistControllerTest.class)
class PlaylistControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PlayListService playListService;

    @Autowired
    private Gson gson;

    @MockBean
    private JwtInterceptor jwtInterceptor;

    @Test
    void whenAddMusicToPlayListThenReturn201() throws Exception {

        Artista artista = new Artista();
        artista.setNome("Alefe");
        Musica musica = new Musica();
        musica.setId("67f5976c-eb1e-404e-8220-2c2a8a23be47");
        musica.setNome("Abobora");
        musica.setArtista(artista);
        List<Musica> musicaList = new ArrayList<>();
        musicaList.add(musica);
        MusicaDto dto = new MusicaDto(musicaList);
        when(playListService.adicionarMusicaNaPlayList(musica,"92d8123f-e9f6-4806-8e0e-1c6a5d46f2ed")).thenReturn(dto);

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/api/playlists/92d8123f-e9f6-4806-8e0e-1c6a5d46f2ed/musicas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new Musica("Alefe ama teste",artista)))

                        .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}