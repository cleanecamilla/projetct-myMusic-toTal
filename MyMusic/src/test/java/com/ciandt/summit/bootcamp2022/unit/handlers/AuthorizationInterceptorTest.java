package com.ciandt.summit.bootcamp2022.unit.handlers;

import com.ciandt.summit.bootcamp2022.application.adapters.controllers.MusicController;
import com.ciandt.summit.bootcamp2022.domains.token.dto.CreateAuthorizer;
import com.ciandt.summit.bootcamp2022.domains.token.dto.CreateAuthorizerData;
import com.ciandt.summit.bootcamp2022.infra.feignclients.TokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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
    private TokenProvider tokenProvider;

    @MockBean
    private MusicController musicController;

    private final String TOKEN = "token";
    private final String USER = "user";

    private CreateAuthorizer fakeCreateAuthorizer;

    @BeforeEach
    public void setup() {
        CreateAuthorizerData createAuthorizerData = new CreateAuthorizerData(TOKEN, USER);
        fakeCreateAuthorizer = new CreateAuthorizer(createAuthorizerData);
    }

    @Test
    public void authorizeRequestTest() throws Exception {
        String expected = "authorized";

        when(musicController.get())
                .thenReturn(ResponseEntity.ok(expected));

        when(tokenProvider.createTokenAuthorizer(fakeCreateAuthorizer))
                .thenReturn(ResponseEntity.status(201).body("ok"));

        mockMvc.perform(
                    get("/api/v1/music")
                        .header("token", TOKEN)
                            .header("user", USER)
                )
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
