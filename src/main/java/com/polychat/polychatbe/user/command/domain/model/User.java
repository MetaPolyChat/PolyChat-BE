package com.polychat.polychatbe.user.command.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_USER")
public class User {

    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @Column(name="USER_NAME")
    private String userName;

    public User() {}

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
