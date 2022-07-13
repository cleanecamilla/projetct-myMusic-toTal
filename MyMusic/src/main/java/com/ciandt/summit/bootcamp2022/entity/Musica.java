package com.ciandt.summit.bootcamp2022.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Musicas")
public class Musica {

    @Id
    private final String id = UUID.randomUUID().toString();
    @Column
    private String nome;
    @OneToOne
    @JoinColumn(name = "ArtistaId")
    private Artista artista;

    public Musica() {
    }

    public Musica(String nome, Artista artistaId) {
        this.nome = nome;
        this.artista = artistaId;
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

    public Artista getArtistaId() {
        return artista;
    }

    public void setArtistaId(Artista artistaId) {
        this.artista = artistaId;
    }
}
