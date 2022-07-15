package com.ciandt.summit.bootcamp2022.controller;

import com.ciandt.summit.bootcamp2022.controller.dto.MusicaDto;
import com.ciandt.summit.bootcamp2022.entity.Artista;
import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.exceptions.FiltroErrorException;
import com.ciandt.summit.bootcamp2022.exceptions.MusicaErrorResponse;
import com.ciandt.summit.bootcamp2022.service.MusicaService;
import static org.junit.jupiter.api.Assertions.*;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@Import(MusicController.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MusicControllerTest.class)
public class MusicControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MusicaService musicaService;

    @Autowired
    private Gson gson;

    @Test
    void whenGetThenReturnString() throws Exception {
        RequestBuilder request = get("/api/v1/music");

        MvcResult result = mvc.perform(request).andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertEquals("67f5976c-eb1e-404e-8220-2c2a8a23be47", result.getResponse().getContentAsString());
    }

    @Test
    void whenFindMusicWithFilterThereNoRegisters() throws Exception {

        List<Musica> musicaReturnWhenCallFindMusicFunction = new ArrayList<>();

        MusicaDto musicaDto = new MusicaDto(musicaReturnWhenCallFindMusicFunction);

        when(musicaService.buscar("saiu")).thenReturn(musicaDto);

        RequestBuilder request = get("/api/v1/music/buscar")
                .param("filtro", "saiu");
        MvcResult result = mvc.perform(request).andReturn();

        assertEquals(204, result.getResponse().getStatus());

    }

    @Test
    void whenFindMusicWithFilterThatThereAreRegisters() throws Exception {

        Artista artista = new Artista("Leonardo");

        Musica musica = new Musica("Talking to the moon", artista);

        List<Musica> musicaList = new ArrayList<>(Collections.singletonList(musica));

        MusicaDto musicaDto = new MusicaDto(musicaList);

        when(musicaService.buscar("bru")).thenReturn(musicaDto);

        RequestBuilder request = get("/api/v1/music/buscar")
                .param("filtro", "bru");

        MvcResult result = mvc.perform(request).andReturn();

        MusicaDto convertReturnInObject = gson.fromJson(result.getResponse().getContentAsString(), MusicaDto.class);

        assertEquals(200, result.getResponse().getStatus());
        assertFalse(convertReturnInObject.getData().isEmpty());
    }

    @Test
    void whenFindMusicWithFilterThatThereNotRegistersThenReturn204() throws Exception {

        List<Musica> musicaList = new ArrayList<>();

        MusicaDto musicaDto = new MusicaDto(musicaList);

        when(musicaService.buscar("saiu")).thenReturn(musicaDto);

        RequestBuilder request = get("/api/v1/music/buscar")
                .param("filtro", "saiu");

        MvcResult result = mvc.perform(request).andReturn();


        assertEquals(204, result.getResponse().getStatus());
    }

    @Test
    void whenFindMusicWithIvalidFilterThenReturnException() throws Exception {

        List<Musica> musicaList = new ArrayList<>();

        MusicaDto musicaDto = new MusicaDto(musicaList);

        when(musicaService.buscar("br")).thenThrow(FiltroErrorException.class);

        RequestBuilder request = get("/api/v1/music/buscar")
                .param("filtro", "br");

        MvcResult result = mvc.perform(request).andReturn();

        MusicaErrorResponse convertReturnInObject = gson.fromJson(result.getResponse().getContentAsString(), MusicaErrorResponse.class);

        assertThrows(FiltroErrorException.class, () -> musicaService.buscar("br"));
        assertEquals("Numeros de caracteres invalidos!", convertReturnInObject.getMessage());
        assertNotNull(convertReturnInObject);

    }

}
