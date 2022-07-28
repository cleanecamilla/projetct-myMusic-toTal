package com.ciandt.summit.bootcamp2022.common.exception.service;

import com.ciandt.summit.bootcamp2022.entity.Artist;
import com.ciandt.summit.bootcamp2022.entity.Music;
import com.ciandt.summit.bootcamp2022.repository.ArtistRepository;
import com.ciandt.summit.bootcamp2022.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicRepository musicRepository;
    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public boolean isAValidSearch(String filter) {
        if (filter.length() < 2){
            return false;
        }
        return true;
    }



    @Override
    public Map<Artist, Set<Music>> searchMusicsByFilter(String filter) {

        if(isAValidSearch(filter)){


            Set<Artist> foundedArtists = artistRepository.findByNameContainingIgnoreCaseOrderByNameAsc(filter);
            Map<Artist, Set<Music>> musics = new HashMap<>();


            for (Artist artist : foundedArtists) {
                Set<Music> foundedMusics = musicRepository.findByArtist(artist);
                musics.put(artist, foundedMusics);

            }

            Set<Music> foundedMusics = musicRepository.findByNameContainingIgnoreCaseOrderByNameAsc(filter);

            for (Music music : foundedMusics) {
                if(!musics.containsKey(music.getArtist())){
                    musics.put(music.getArtist(), Collections.singleton(music));
                } else {
                    Set<Music> artistsMusics = musics.get(music.getArtist());
                    artistsMusics.add(music);
                    musics.put(music.getArtist(), artistsMusics);
                }
            }

            return musics;
        }

        throw new RuntimeException();

    }



    @Override
    public Set<Music> searchAllMusics(){

        Set<Music> allMusics = musicRepository.findByNameContainingIgnoreCaseOrderByNameAsc("");

        if(allMusics.isEmpty()){
            throw new RuntimeException();

        }

        return allMusics;

    }

    @Override
    public Set<Music> searchMusicByName(String filtro) {
        Set<Music> musics = new HashSet<>();

        for (Music music: musics) {
           if(music.getName().contains(filtro)){
               musics.add(music);
           }
        }
        return musics;
    }
}
