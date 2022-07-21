package com.ciandt.summit.bootcamp2022.controller.request;

import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.model.MusicaDTO;

public class PlaylistRequest {

    MusicaDTO data;

    public PlaylistRequest() {
    }

    public PlaylistRequest(MusicaDTO data) {
        this.data = data;
    }

    public MusicaDTO getData() {
        return data;
    }

}
