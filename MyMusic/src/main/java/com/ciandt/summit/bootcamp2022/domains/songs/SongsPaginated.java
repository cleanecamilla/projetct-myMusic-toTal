package com.ciandt.summit.bootcamp2022.domains.songs;

import java.util.List;

public class SongsPaginated {
    private List<Song> data;
    private long totalElements;
    private final int ROWS_PER_PAGE = 10;

    public SongsPaginated(List<Song> songList, long totalElements) {
        this.data = songList;
        this.totalElements = totalElements;
    }

    public List<Song> getData() {
        return data;
    }

    public void setData(List<Song> data) {
        this.data = data;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getROWS_PER_PAGE() {
        return ROWS_PER_PAGE;
    }
}