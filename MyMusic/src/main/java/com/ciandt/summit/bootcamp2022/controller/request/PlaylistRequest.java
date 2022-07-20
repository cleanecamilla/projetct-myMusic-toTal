package com.ciandt.summit.bootcamp2022.controller.request;

import com.ciandt.summit.bootcamp2022.entity.Musica;

public class PlaylistRequest {

    Musica data;

    public PlaylistRequest() {
    }

    public PlaylistRequest(Musica data) {
        this.data = data;
    }

    public Musica getData() {
        return data;
    }

}
