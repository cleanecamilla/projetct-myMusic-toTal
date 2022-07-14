package com.ciandt.summit.bootcamp2022.controller;

import com.ciandt.summit.bootcamp2022.entity.Artista;
import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.service.MusicaServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MusicController.class)
public class MusicControllerTest {

    @MockBean
    MusicaServiceImp musicaServiceImp;

    @Autowired
    private MockMvc mvc;

    @Test
    void test_buscarMusica() throws Exception {
        Musica musica = new Musica();
        musica.setId("4ffb5d4f-8b7f-4996-b84b-ecf751f52eea");
        musica.setNome("B.B. On Mars");

        Artista artista = new Artista();
        artista.setId("30ab1678-c616-4314-adcc-918aff5a7a13");
        artista.setNome("Alice Cooper");
        musica.setArtista(artista);

        given(musicaServiceImp.buscarMusicas("B.B. On Mars")).willReturn(new ArrayList<>(List.of(musica)));

        RequestBuilder request = get("/api/musicas?filtro=B.B. On Mars");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("[{\"id\":\"4ffb5d4f-8b7f-4996-b84b-ecf751f52eea\",\"nome\":\"B.B. On Mars\",\"artista\":{\"id\":\"30ab1678-c616-4314-adcc-918aff5a7a13\",\"nome\":\"Alice Cooper\"}}]",
                result.getResponse().getContentAsString());
    }
}
