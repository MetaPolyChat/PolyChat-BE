package com.polychat.polychatbe.user.command.application.dto;

public enum UserRole {

    MEMBER("MEMBER"),
    ADMIN("ADMIN"),
    ALL("MEMBER,ADMIN");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
