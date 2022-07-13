package com.ciandt.summit.bootcamp2022.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Artistas")
public class Artista {

    @Id
    private final String id = UUID.randomUUID().toString();
    @Column
    private String nome;

    public Artista(){}

    public Artista(String nome) {
        this.nome = nome;
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
}