package com.ciandt.summit.bootcamp2022.service.impl;

import com.ciandt.summit.bootcamp2022.dto.MusicDTO;
import com.ciandt.summit.bootcamp2022.entity.Artist;
import com.ciandt.summit.bootcamp2022.entity.Music;
import com.ciandt.summit.bootcamp2022.exception.MusicNotFound;
import com.ciandt.summit.bootcamp2022.repository.MusicRepository;
import com.ciandt.summit.bootcamp2022.service.mapper.ArtistDTOMapper;
import com.ciandt.summit.bootcamp2022.service.mapper.MusicDTOMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.hamcrest.Matchers.isA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


public class MusicServiceImplTest {

    @InjectMocks
    private MusicServiceImpl musicService;

    @Mock
    private MusicRepository musicRepository;

    @InjectMocks
    private MusicDTOMapper INSTANCE = MusicDTOMapper.INSTANCE;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        musicService = new MusicServiceImpl(musicRepository);
        mapStructSetup();
    }

    public void mapStructSetup() {
        ArtistDTOMapper artistDTOMapper = Mappers.getMapper(ArtistDTOMapper.class);
        ReflectionTestUtils.setField(INSTANCE, "artistDTOMapper", artistDTOMapper);
        musicService.setMusicDTOMapper(INSTANCE);
    }

    @Test
    void findAllWithFilter() {
        final Set<Music> music = new HashSet<>();
        final String filter = "sucesso";

        music.addAll(buildEntitySet("Paralamas", "do Sucesso"));
        music.addAll(buildEntitySet("Anitta", "com Sucesso"));

        given(musicRepository.findAllWithFilter(anyString(), any()))
                .willReturn(music);

        Set<MusicDTO> setAtual = musicService.findAllWithFilter(filter);

        Set<MusicDTO> setEsperado = INSTANCE.toSetOfDTO(music);

        assertEquals(setEsperado.size(), setAtual.size());
        assertEquals(setEsperado, setAtual);
    }

    @Test
    void whenNotFindAllWithFilterByName() {

        given(musicRepository.findAllWithFilter(anyString(), any()))
                .willReturn(Collections.emptySet());

        MusicNotFound thrown = assertThrows(
                MusicNotFound.class,
                () -> musicService.findAllWithFilter("ada"),
                "Exception not found"
        );

        assertEquals(thrown.getClass(), MusicNotFound.class);
    }

    private Music buildMusicEntity(String name, Artist a){
        Music m = new Music();
        m.setName(name);
        m.setId(UUID.nameUUIDFromBytes(name.getBytes()).toString());
        m.setArtist(a);
        return m;
    }

    public Set<Music> buildEntitySet(String artistName, String musicName) {
        Set<Music> set = new HashSet();
        Artist artist = new Artist();
        artist.setId(UUID.nameUUIDFromBytes(artistName.getBytes()).toString());
        artist.setName(artistName);

        Music music = buildMusicEntity(musicName, artist);
        set.add(music);

        return set;
    }
}