package com.ciandt.summit.bootcamp2022.controller;

import com.ciandt.summit.bootcamp2022.entity.Artist;
import com.ciandt.summit.bootcamp2022.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/sample")
    public ResponseEntity<Artist> findAny_Sample(){
        return ResponseEntity.ok(
                artistService.findAny_Sample()
        );
    }


}
