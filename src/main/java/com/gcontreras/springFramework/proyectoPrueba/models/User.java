package com.gcontreras.springFramework.proyectoPrueba.models;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class User {
    private String nickname;
    private String username;
    private String password;

    public User(String nickname, String username, String password) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }
}
