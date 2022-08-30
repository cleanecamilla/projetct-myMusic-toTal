package com.ciandt.summit.bootcamp2022.application.adapters.controllers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Set;

@WebMvcTest(MusicController.class)
public class MusicControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private MusicController musicController;

    @Test
    void getMusicTest() throws Exception {
        Mockito.when(musicController.getMusic()).thenReturn(new ResponseEntity<Set<MusicDTO>>(HttpStatus.OK));
        RequestBuilder requestBuilder = get("api/musicas/all");
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        Assertions.assertEquals(requestBuilder, mvcResult);
    }

    @Test
    void findMusicByNameTest() throws Exception {
        Mockito.when(musicController.findMusicByName("u2")).thenReturn(new ResponseEntity<Set<MusicDTO>>(HttpStatus.OK));
        RequestBuilder requestBuilder = get("api/musicas/musics?name=u2");
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        Assertions.assertEquals(requestBuilder, mvcResult);
    }

    @Test
    void couldNotFindMusicByNameTest() throws Exception {
        Mockito.when(musicController.findMusicByName(null)).thenThrow(new Exception()); // trocar exception pelas exceptions criadas
        RequestBuilder requestBuilder = get("api/musicas/musics?name=");
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        Assertions.assertEquals(requestBuilder, mvcResult);
    }

    @Test
    void nameWithLessOfTwoCharactersTest() throws Exception {
        Mockito.when(musicController.findMusicByName("u")).thenThrow(new Exception()); // trocar exception pelas exceptions criadas
        RequestBuilder requestBuilder = get("api/musicas/musics?name=u");
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        Assertions.assertEquals(requestBuilder, mvcResult);
    }

//    @Test void addMusicsTest() throws Exception {
//        MusicDTO musicDTO = new MusicDTO("1", "Sunday Blood Sunday", "32844fdd-bb76-4c0a-9627-e34ddc9fd892");
//        Mockito.when(musicController.addMusics(musicDTO)).;
//    }

}
