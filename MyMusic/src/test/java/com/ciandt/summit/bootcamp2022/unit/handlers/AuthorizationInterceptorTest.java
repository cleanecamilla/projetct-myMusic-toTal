package com.ciandt.summit.bootcamp2022.unit.handlers;

import com.ciandt.summit.bootcamp2022.SummitBootcampApplication;
import com.ciandt.summit.bootcamp2022.application.adapters.controllers.MusicController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//TODO: refinar testes após a conclusão da feature 812

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MusicController.class)
public class AuthorizationInterceptorTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MusicController musicController;

    @Test
    public void authorizeRequestTest() throws Exception {
        String expected = "authorized";
        when(musicController.get()).thenReturn(ResponseEntity.ok(expected));

        mockMvc.perform(get("/api/v1/music"))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    public void unauthorizedRequestTest() throws Exception {
        String expected = "unauthorized";
        when(musicController.get()).thenReturn(ResponseEntity.ok(expected));

        mockMvc.perform(get("/api/v1/music"))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string(expected));
    }
}
