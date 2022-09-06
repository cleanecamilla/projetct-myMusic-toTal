package com.ciandt.summit.bootcamp2022.domain.dtos;

public class UserDTO {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String playListId;

    public UserDTO() {

    }

    public UserDTO(String id, String name, String playListId) {
        this.id = id;
        this.name = name;
        this.playListId = playListId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayListId() {
        return playListId;
    }

    public void setPlayListId(String playListId) {
        this.playListId = playListId;
    }
}
