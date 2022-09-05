package com.ciandt.summit.bootcamp2022.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Playlists")
@Data
public class Playlist {

    @Id
    private String id;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "PlaylistMusicas",
            joinColumns = @JoinColumn(name = "PlaylistId"),
            inverseJoinColumns = @JoinColumn(name = "MusicaId"))
    private Set<Music> musics;

}
