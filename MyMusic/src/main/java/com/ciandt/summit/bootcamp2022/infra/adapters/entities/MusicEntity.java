package com.ciandt.summit.bootcamp2022.infra.adapters.entities;

import com.ciandt.summit.bootcamp2022.domain.Music;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Musicas")
public class MusicEntity {
    @Id
    @Column(name="Id")
    private String id;
    @Column(name="Nome")
    private String nome;
    @Column(name="ArtistaId")
    private String artistaId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MusicEntity(String id, String nome, String artistaId) {
        this.id = id;
        this.nome = nome;
        this.artistaId = artistaId;
    }

    public MusicEntity() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(String artistaId) {
        this.artistaId = artistaId;
    }

    public Music toMusic() {
        return new Music(this.id, this.nome, this.artistaId);
    }
}
