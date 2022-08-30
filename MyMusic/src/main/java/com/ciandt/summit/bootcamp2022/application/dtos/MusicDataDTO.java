package com.ciandt.summit.bootcamp2022.application.dtos;

import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;

import java.io.Serializable;
import java.util.List;

public class MusicDataDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<MusicDTO> data;

    public MusicDataDTO() {}

    public MusicDataDTO(List<MusicDTO> data) {
        this.data = data;
    }

    public List<MusicDTO> getMusicList() {
        return data;
    }

}
