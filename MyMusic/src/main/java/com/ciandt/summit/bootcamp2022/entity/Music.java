package com.ciandt.summit.bootcamp2022.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Musicas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Music {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "ArtistaId", referencedColumnName = "Id")
    private Artist artist;

    @Column(name = "Nome")
    private String name;

}
