package com.ciandt.summit.bootcamp2022.infra.adapters.entities;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="Id")
    private String id;
    @Column(name="Nome")
    private String name;
    @OneToOne(mappedBy = "musics")
    private String playListId;

    public UserEntity() {
    }

    public UserEntity(String id, String name, String playListId) {
        this.id = id;
        this.name = name;
        this.playListId = playListId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayListId() {
        return playListId;
    }

    public void setPlayListId(String playListId) {
        this.playListId = playListId;
    }
}
