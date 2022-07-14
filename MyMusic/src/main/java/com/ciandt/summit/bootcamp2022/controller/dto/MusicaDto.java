package com.ciandt.summit.bootcamp2022.controller.dto;

import com.ciandt.summit.bootcamp2022.entity.Artista;
import com.ciandt.summit.bootcamp2022.entity.Musica;

import java.util.List;

public class MusicaDto {

    public MusicaDto(List<Musica> listaMusica) {
        this.data = listaMusica;
    }

    private List<Musica> data;

    public List<Musica> getData() {
        return data;
    }

    public void setData(List<Musica> data) {
        this.data = data;
    }
}
