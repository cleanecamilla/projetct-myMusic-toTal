package com.ciandt.summit.bootcamp2022.controller;

import com.ciandt.summit.bootcamp2022.service.MusicService;
import com.ciandt.summit.bootcamp2022.dto.MusicDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
@Validated
public class MusicController {

    private final MusicService musicService;

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("67f5976c-eb1e-404e-8220-2c2a8a23be47");
    }

    @GetMapping("/musicas")
    public ResponseEntity<Set<MusicDTO>> findAllWithFilterByName(
            @RequestParam(name = "filtro", required = false)
            @Size(min = 2, message = "The filter must have at least 2 characters")  final String filter){

        return
                ResponseEntity.ok(musicService.findAllWithFilter(filter));
    }
}
