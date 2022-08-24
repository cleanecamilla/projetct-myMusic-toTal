package com.ciandt.summit.bootcamp2022.unit.handlers;

import com.ciandt.summit.bootcamp2022.application.adapters.controllers.MusicController;
import com.ciandt.summit.bootcamp2022.domains.exceptions.tokens.BadAuthRequestException;
import com.ciandt.summit.bootcamp2022.domains.token.dto.CreateAuthorizerDTO;
import com.ciandt.summit.bootcamp2022.domains.token.dto.CreateAuthorizerDataDTO;
import com.ciandt.summit.bootcamp2022.infra.feignclients.TokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
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

    private CreateAuthorizerDTO fakeCreateAuthorizer;

    @BeforeEach
    public void setup() {
        CreateAuthorizerDataDTO createAuthorizerData = new CreateAuthorizerDataDTO(TOKEN, USER);
        fakeCreateAuthorizer = new CreateAuthorizerDTO(createAuthorizerData);
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
    public void authHeadersNotFoundTest() throws Exception {
        mockMvc.perform(get("/api/v1/music"))
                .andExpect(result -> {
                    Exception exception = result.getResolvedException();

                    assertTrue(exception instanceof BadAuthRequestException);
                    assertEquals(exception.getMessage(), "Auth headers not found: user or token are blank or null");
                })
                .andExpect(status().isBadRequest());
    }

    @Test
    public void unauthorizedRequestTest() throws Exception {
        when(tokenProvider.createTokenAuthorizer(fakeCreateAuthorizer))
                .thenThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token expirado"));

        mockMvc.perform(
                    get("/api/v1/music")
                            .header("token", TOKEN)
                            .header("user", USER)
                )
                .andExpect(status().isUnauthorized());
    }
}
