package com.ciandt.summit.bootcamp2022.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Musicas")
public class Musica implements Comparable<Musica>{

    @Id
    private String id;
    private String nome;
    @OneToOne
    @JoinColumn(name = "ArtistaId")
    private Artista artista;

    public Musica() {

    }

    public Musica(String id, String nome, Artista artista) {
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

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Musica musica = (Musica) o;

        return id != null ? id.equals(musica.id) : musica.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public int compareTo(Musica o) {
        return this.nome.compareToIgnoreCase(o.nome);
    }

    @Override
    public String toString() {
        return this.id + " :: " + this.nome;
    }
}
