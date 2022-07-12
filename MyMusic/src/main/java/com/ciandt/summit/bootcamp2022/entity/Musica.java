package com.ciandt.summit.bootcamp2022.entity;

import javax.persistence.*;

@Entity
@Table(name = "Artistas")
public class Musica {

    @Id
    private String id;
    private String nome;
    @OneToOne
    @JoinColumn(name = "ArtistaId")
    private Artista artista;

    public Musica() {

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

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
