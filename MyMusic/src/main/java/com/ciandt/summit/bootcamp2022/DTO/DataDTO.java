package com.ciandt.summit.bootcamp2022.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DataDTO {
    private List<MusicDTO> musicDTOList;
}
