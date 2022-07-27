package com.ciandt.summit.bootcamp2022.DTO;

import com.ciandt.summit.bootcamp2022.entity.Artista;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MusicDTO {
    private String id;
    private String nome;
    private Artista artista;
}
