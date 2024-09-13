package com.polychat.polychatbe.user.command.domain.model;

import com.polychat.polychatbe.user.command.application.dto.Authority;
import com.polychat.polychatbe.user.command.application.dto.LoginType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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

    @Column(name="LOGIN_TYPE", nullable = false)
    @Enumerated(value = EnumType.STRING)
    @ColumnDefault("'NONE'")
    private LoginType loginType;

    @Column(name="AUTHORITY", nullable = false)
    @Enumerated(value = EnumType.STRING)
    @ColumnDefault("'USER'")
    private Authority authority;

    public User(String userId, String userName, String password, LoginType loginType, Authority authority) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.loginType = loginType;
        this.authority = authority;
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

    public String getPassword() {
        return password;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public Authority getAuthority() {
        return authority;
    }

    @Override
    public String toString() {
        return "User{" +
                "userNo=" + userNo +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", loginType=" + loginType +
                ", authority=" + authority +
                '}';
    }
}
