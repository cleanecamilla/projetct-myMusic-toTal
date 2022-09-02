package com.ciandt.summit.bootcamp2022.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(name = "Music", description = "Representation of a Music")
public class MusicDTO {

    @Schema(description = "Unique value that represents a Music in database")
    private UUID id;
    @Schema(description = "Music's name")
    private String name;
    @Schema(description = "Music's author or artist")
    private ArtistDTO artist;
}
