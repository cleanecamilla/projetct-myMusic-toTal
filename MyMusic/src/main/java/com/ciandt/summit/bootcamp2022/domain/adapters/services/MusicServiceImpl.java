package com.ciandt.summit.bootcamp2022.domain.adapters.services;

import com.ciandt.summit.bootcamp2022.domain.Music;

import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import com.ciandt.summit.bootcamp2022.domain.ports.interfaces.MusicServicePort;

import com.ciandt.summit.bootcamp2022.domain.ports.repositories.MusicRepositoryPort;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MusicServiceImpl implements MusicServicePort {

    private final MusicRepositoryPort musicRepositoryPort;

    public MusicServiceImpl(MusicRepositoryPort musicRepositoryPort) {
        this.musicRepositoryPort = musicRepositoryPort;
    }


    @Override
    public Set<MusicDTO> searchMusics() {
        Set<Music> musicList = this.musicRepositoryPort.searchMusics();
        Set<MusicDTO> musicDTOS = musicList.stream().map(Music::toMusicDTO).collect(Collectors.toSet());
        return musicDTOS;
    }

    public List<MusicDTO> getMusicsByFilter(String name) { // Comunicação com as Exceptions
        Set<Music> musicListFiltered = this.musicRepositoryPort.getMusicsByFilter(name);
        return musicListFiltered.stream().map(Music::toMusicDTO).collect(Collectors.toList());
    }

    @Override
    public void addMusic(MusicDTO musicDTO) {
        Music music = new Music(musicDTO);
        this.musicRepositoryPort.save(music);
    }
}