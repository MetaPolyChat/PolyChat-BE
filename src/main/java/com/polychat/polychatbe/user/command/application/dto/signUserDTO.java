package com.polychat.polychatbe.user.command.application.dto;

public class signUserDTO {

    private String email;
    private String userName;
    private String password;

    public signUserDTO() {}

    public signUserDTO(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
}
