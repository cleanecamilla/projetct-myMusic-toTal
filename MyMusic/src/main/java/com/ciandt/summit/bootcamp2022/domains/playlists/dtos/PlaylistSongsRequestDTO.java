package com.ciandt.summit.bootcamp2022.domains.playlists.dtos;

import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;
import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongListDTO;

import java.util.List;
import java.util.Objects;

public class PlaylistSongsRequestDTO extends SongListDTO {
    public PlaylistSongsRequestDTO(List<SongDTO> data) {
        super(data);
    }

    public PlaylistSongsRequestDTO() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SongListDTO that = (SongListDTO) o;

        return Objects.equals(data, that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public List<SongDTO> getData() {
        return super.getData();
    }

    @Override
    public void setData(List<SongDTO> data) {
        super.setData(data);
    }

    @Override
    public String toString() {
        return "{\"data\": " + data +
                '}';
    }
}
