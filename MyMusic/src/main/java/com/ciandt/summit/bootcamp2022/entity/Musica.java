package com.ciandt.summit.bootcamp2022.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Musicas")
public class Musica {

    @Id
    private String id = UUID.randomUUID().toString();
    @Column
    private String nome;
    @OneToOne
    @JoinColumn(name = "ArtistaId")
    private Artista artista;

    public Musica() {
    }

    public Musica(String nome, Artista artista) {
        this.nome = nome;
        this.artista = artista;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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
