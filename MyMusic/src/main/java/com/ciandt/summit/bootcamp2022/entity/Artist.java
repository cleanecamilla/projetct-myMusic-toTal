package com.ciandt.summit.bootcamp2022.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Artistas")
@Getter
@Setter
public class Artist {

    @Id
    private String id;
    @Column(name = "Nome")
    private String name;

}

