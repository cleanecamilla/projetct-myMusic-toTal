package com.ciandt.summit.bootcamp2022.service.mapper;

import com.ciandt.summit.bootcamp2022.entity.Music;
import com.ciandt.summit.bootcamp2022.service.dto.MusicDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(uses = { ArtistDTOMapper.class } )
public interface MusicDTOMapper {

    MusicDTOMapper INSTANCE = Mappers.getMapper(MusicDTOMapper.class);
    @Mapping(source = "artist.name", target = "artist")
    MusicDTO toDto(Music music);

    @Mapping(source = "artist.name", target = "artist")
    Set<MusicDTO> toSetOfDTO(Set<Music> music);

}
