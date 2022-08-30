package com.ciandt.summit.bootcamp2022.service.mapper;

import com.ciandt.summit.bootcamp2022.entity.Artist;
import com.ciandt.summit.bootcamp2022.dto.ArtistDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArtistDTOMapper {

    ArtistDTOMapper INSTANCE = Mappers.getMapper(ArtistDTOMapper.class);

    ArtistDTO toDTO(Artist entity);
}
