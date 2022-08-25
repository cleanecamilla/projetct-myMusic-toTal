package com.ciandt.summit.bootcamp2022.domains.songs.dtos;

import java.util.List;

public class SongResponseDTO {
    private List<SongDTO> data;
    private long totalElements;
    private final int ROWS_PER_PAGE = 10;

    public SongResponseDTO(List<SongDTO> data) {
        this.data = data;
        this.totalElements = data.size();
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

    public long getTotalElements() {
        return totalElements;
    }

    public int getROWS_PER_PAGE() {
        return ROWS_PER_PAGE;
    }

    @Override
    public String toString() {
        return "{\"data\": " + data + ","
                + "\"totalElements\":" + totalElements
                + ",\"rows_PER_PAGE\": " + getROWS_PER_PAGE() + '}';
    }

}
