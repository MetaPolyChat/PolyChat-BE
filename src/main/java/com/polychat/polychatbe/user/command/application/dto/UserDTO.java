package com.polychat.polychatbe.user.command.application.dto;

import com.polychat.polychatbe.user.command.domain.model.Authority;
import com.polychat.polychatbe.user.command.domain.model.LoginType;
import com.polychat.polychatbe.user.command.domain.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String email;
    private String userName;
    private String password;
    private LoginType loginType;
    private Authority authority;
    private Status status;
    private String planet;
    private LocalDateTime createdAt;
}
