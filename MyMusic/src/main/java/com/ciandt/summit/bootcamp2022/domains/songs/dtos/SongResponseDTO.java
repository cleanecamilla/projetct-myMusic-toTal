package com.ciandt.summit.bootcamp2022.domains.songs.dtos;

import java.util.List;

public class SongResponseDTO {
    private List<SongDTO> data;

    public SongResponseDTO(List<SongDTO> data) {
        this.data = data;
    }

    public List<SongDTO> getData() {
        return data;
    }

    public void setData(List<SongDTO> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{\"data\":" + data + '}';
    }
}
