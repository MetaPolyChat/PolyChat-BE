package com.polychat.polychatbe.user.command.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_USER")
public class User {

    @Id
    @Column(name="USER_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(name="USER_ID")
    private String userId;

    @Column(name="USER_NAME")
    private String userName;

    public User() {}

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public User(Long userNo, String userId, String userName) {
        this.userNo = userNo;
        this.userId = userId;
        this.userName = userName;
    }

    public Long getUserNo() {
        return userNo;
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
