package com.polychat.polychatbe.user.query.dto;

import com.polychat.polychatbe.user.command.domain.model.Authority;
import com.polychat.polychatbe.user.command.domain.model.LoginType;
import com.polychat.polychatbe.user.command.domain.model.Status;

import java.time.LocalDateTime;

public class UserDetailResponseDTO {
    private long userId;
    private String email;
    private String userName;
    private LoginType loginType;
    private Authority authority;
    private Status status;
    private String planet;
    private LocalDateTime createdAt;
}
