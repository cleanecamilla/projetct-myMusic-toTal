package com.ciandt.summit.bootcamp2022.infra.adapters.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class ArtistEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String nome;

    public ArtistEntity(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public ArtistEntity() {
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
}