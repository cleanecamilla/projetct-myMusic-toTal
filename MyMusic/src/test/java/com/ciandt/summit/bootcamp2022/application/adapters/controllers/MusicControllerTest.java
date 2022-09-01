package com.ciandt.summit.bootcamp2022.application.adapters.controllers;

import com.ciandt.summit.bootcamp2022.domain.ports.interfaces.MusicServicePort;
import com.ciandt.summit.bootcamp2022.domain.ports.repositories.MusicRepositoryPort;
import com.ciandt.summit.bootcamp2022.infra.config.BeanConfiguration;
import com.ciandt.summit.bootcamp2022.infra.config.DbConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith({SpringExtension.class})
@WebMvcTest(MusicController.class)
@ContextConfiguration(classes = {DbConfig.class, BeanConfiguration.class, MusicServicePort.class, MusicRepositoryPort.class})
public class MusicControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MusicServicePort musicServicePort;

    @MockBean
    private MusicRepositoryPort musicRepositoryPort;

    @BeforeEach
    void initTest() throws Exception {
        //given(interceptor.preHandle(any(), any(), any())).willReturn(true);
    }

    @Test
    void findMusicByNameTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("").param("name", "bru");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

}
