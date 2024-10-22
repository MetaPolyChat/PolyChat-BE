package com.polychat.polychatbe.user.command.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name="TBL_USER")
public class User {

    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name="EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name="USER_NAME", nullable = false)
    private String userName;

    @Column(name="PASSWORD", nullable = false)
    private String password;

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

    @Column(name = "PLANET", nullable = false, unique = true)
    private String planet;

    @Column(name="CREATED_AT")
    private LocalDateTime createdAt;

    @Builder
    public User(String userName, String password, LoginType loginType, Authority authority, Status status, String email, String planet, LocalDateTime createdAt) {
        this.userName = userName;
        this.password = password;
        this.loginType = loginType;
        this.authority = authority;
        this.status = status;
        this.email = email;
        this.planet = planet;
        this.createdAt = createdAt;
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

    public void updateUserName(String userName) {
        this.userName = userName;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", loginType=" + loginType +
                ", authority=" + authority +
                ", status=" + status +
                ", planet='" + planet + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
