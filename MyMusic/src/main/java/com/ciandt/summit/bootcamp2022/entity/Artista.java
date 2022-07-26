package com.ciandt.summit.bootcamp2022.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Artistas")
@Getter
@NoArgsConstructor
public class Artista implements Serializable {

    private static final long serialVersionUID = -2346155250576193121L;

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Nome")
    private String nome;

    @OneToMany
    private Set<Musica> musicas = new HashSet<>();

    public Artista(String nome){
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return id.equals(artista.id) && nome.equals(artista.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}