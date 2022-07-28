package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.entity.Artist;
import com.ciandt.summit.bootcamp2022.entity.Music;

import java.util.Map;
import java.util.Set;

public interface MusicService {

    boolean isAValidSearch(String filter); //To verify if has more than 2 caracthers.
    Map<Artist, Set<Music>> searchMusicsByFilter(String filter); // Search in music and artist tables on dabatase.

    Set<Music> searchAllMusics();

    Set<Music> searchMusicByName(String nome);

    
}