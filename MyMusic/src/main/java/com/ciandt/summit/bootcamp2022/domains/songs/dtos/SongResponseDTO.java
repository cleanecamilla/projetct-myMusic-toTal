package com.ciandt.summit.bootcamp2022.domains.songs.dtos;

import com.ciandt.summit.bootcamp2022.domains.songs.SongsPaginated;

import java.util.List;

public class SongResponseDTO {
    private List<SongDTO> data;
    private long totalElements;
    private final int ROWS_PER_PAGE = 10;

    public SongResponseDTO(List<SongDTO> data) {
        this.data = data;
    }

    public SongResponseDTO(List<SongDTO> songs, long totalElements) {
        this(songs);
        this.totalElements = totalElements;
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
