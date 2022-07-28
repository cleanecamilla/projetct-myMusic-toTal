package com.ciandt.summit.bootcamp2022.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Artistas")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Artist implements Serializable {

    private static final long serialVersionUID = -2346155250576193121L;

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Nome")
    @NonNull
    private String name;

    @OneToMany
    @EqualsAndHashCode.Exclude private Set<Music> musics = new HashSet<>();

}