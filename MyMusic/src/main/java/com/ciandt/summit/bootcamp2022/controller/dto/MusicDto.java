package com.ciandt.summit.bootcamp2022.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MusicDto {
    private String id;
    private String nome;
    private ArtistDto artista;
}
