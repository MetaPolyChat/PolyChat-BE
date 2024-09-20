package com.polychat.polychatbe.user.command.domain.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="TBL_USER")
public class User {

    @Id
    @Column(name="USER_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(name="USER_ID", nullable = false, unique = true)
    private String userId;

    @Column(name="USER_NAME", nullable = false)
    private String userName;

    @Column(name="PASSWORD", nullable = false)
    private String password;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(name="LOGIN_TYPE", nullable = false)
    @Enumerated(value = EnumType.STRING)
    @ColumnDefault("'NONE'")
    private LoginType loginType;

    @Column(name="AUTHORITY", nullable = false)
    @Enumerated(value = EnumType.STRING)
    @ColumnDefault("'USER'")
    private Authority authority;

    @Column(name="STATUS")
    @Enumerated(value = EnumType.STRING)
    @ColumnDefault("'ACTIVATED'")
    private Status status;

    @Column(name = "PLANET", nullable = false)
    private String planet;


    @Builder
    public User(String userId, String userName, String password, LoginType loginType, Authority authority, Status status, String email, String planet) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.loginType = loginType;
        this.authority = authority;
        this.status = status;
        this.email = email;
        this.planet = planet;
    }

    @Override
    public String toString() {
        return "User{" +
                "userNo=" + userNo +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", loginType=" + loginType +
                ", authority=" + authority +
                ", status=" + status +
                ", planet='" + planet + '\'' +
                '}';
    }
}
