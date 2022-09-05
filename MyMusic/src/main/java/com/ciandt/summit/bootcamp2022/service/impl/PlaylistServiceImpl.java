package com.ciandt.summit.bootcamp2022.service.impl;

import com.ciandt.summit.bootcamp2022.dto.MusicDTO;
import com.ciandt.summit.bootcamp2022.entity.Music;
import com.ciandt.summit.bootcamp2022.entity.Playlist;
import com.ciandt.summit.bootcamp2022.exception.PlaylistNotFoundException;
import com.ciandt.summit.bootcamp2022.repository.PlaylistRepository;
import com.ciandt.summit.bootcamp2022.service.MusicService;
import com.ciandt.summit.bootcamp2022.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final MusicService musicService;

    @Transactional
    public Playlist addMusicToPlaylist(String id, MusicDTO musicDTO){

        Music music = musicService.findById(musicDTO.getId());

        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(PlaylistNotFoundException::new);

           playlist.getMusics().add(music);
           return playlistRepository.save(playlist);

    }

}
