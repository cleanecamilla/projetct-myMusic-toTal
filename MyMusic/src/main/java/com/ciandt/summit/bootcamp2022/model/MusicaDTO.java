package com.ciandt.summit.bootcamp2022.model;

import com.ciandt.summit.bootcamp2022.entity.Artista;

public class MusicaDTO {

    private String id;
    private String nome;
    private ArtistaDTO artista;

    public MusicaDTO(String id, String nome, ArtistaDTO artista) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArtistaDTO getArtista() {
        return artista;
    }

    public void setArtista(ArtistaDTO artista) {
        this.artista = artista;
    }
}
