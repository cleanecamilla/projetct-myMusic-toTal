package com.ciandt.summit.bootcamp2022.test.services;

import com.ciandt.summit.bootcamp2022.controller.AuthenticationController;
import com.ciandt.summit.bootcamp2022.dto.AuthRequest;
import com.ciandt.summit.bootcamp2022.repository.UserRepository;
import com.ciandt.summit.bootcamp2022.service.TokenProviderService;
import com.ciandt.summit.bootcamp2022.service.UserService;
import com.ciandt.summit.bootcamp2022.service.impl.TokenProviderServiceImpl;
import com.ciandt.summit.bootcamp2022.service.impl.UserServiceImpl;
import io.micrometer.core.instrument.binder.http.HttpRequestTags;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TokenProviderServiceTest {

    @Autowired
    private MockMvc mock;
    @Mock
    private TokenProviderServiceImpl tokenProviderServiceImpl;

    @InjectMocks
    private UserServiceImpl userService;

    @MockBean
    private TokenProviderService tokenProviderService;

    private String universalToken;

    @BeforeAll
    public void getAToken(){
        when(tokenProviderServiceImpl.getToken("maria")).then(AdditionalAnswers.returnsFirstArg());
        universalToken = tokenProviderServiceImpl.getToken("maria");
    }

    @Test
    public void isTokenAString(){
        when(tokenProviderServiceImpl.getToken("maria")).then(AdditionalAnswers.returnsFirstArg());
        String token = tokenProviderServiceImpl.getToken("maria");
        Assertions.assertThat(tokenProviderServiceImpl.getToken("maria")).isInstanceOf(String.class);
    }

    @Test
    public void testTheFlow(){
        try {
            this.mock.perform(MockMvcRequestBuilders.post("localhost:8080/auth/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{ 'username': 'joao'}"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Basic")));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
