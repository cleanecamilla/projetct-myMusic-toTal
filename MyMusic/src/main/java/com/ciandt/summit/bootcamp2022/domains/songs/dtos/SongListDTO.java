package com.ciandt.summit.bootcamp2022.domains.songs.dtos;

import java.util.List;

public class SongListDTO {
    protected List<SongDTO> data;

    public SongListDTO() {
    }

    public SongListDTO(List<SongDTO> data) {
        this.data = data;
    }

    public List<SongDTO> getData() {
        return data;
    }

    public void setData(List<SongDTO> data) {
        this.data = data;
    }
}
