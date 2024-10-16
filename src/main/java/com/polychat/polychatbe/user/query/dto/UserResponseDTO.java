package com.polychat.polychatbe.user.query.dto;

import com.polychat.polychatbe.user.command.domain.model.Authority;
import com.polychat.polychatbe.user.command.domain.model.LoginType;
import com.polychat.polychatbe.user.command.domain.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private long userId;
    private String email;
    private String userName;
    private LoginType loginType;
    private Authority authority;
    private Status status;
    private String planet;

}
