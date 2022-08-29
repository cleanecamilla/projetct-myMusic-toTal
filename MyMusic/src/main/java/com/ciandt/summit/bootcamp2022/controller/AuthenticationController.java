package com.ciandt.summit.bootcamp2022.controller;

import com.ciandt.summit.bootcamp2022.dto.AuthRequest;
import com.ciandt.summit.bootcamp2022.service.TokenProviderService;
import com.ciandt.summit.bootcamp2022.util.EncodeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    final TokenProviderService tokenProviderService;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest){
        String username = authRequest.getUsername();
        //TODO: busca no banco
        String token = tokenProviderService.getToken(username);
        String base64 = EncodeUtil.encodeAuth(username, token);
        return ResponseEntity.ok("Basic " + base64);
    }
}
