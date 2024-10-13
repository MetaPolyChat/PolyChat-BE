package com.polychat.polychatbe.user.command.application.dto;

import com.polychat.polychatbe.user.command.domain.model.Authority;
import com.polychat.polychatbe.user.command.domain.model.Status;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserModifyDTO {
    private final long modifierId;
    private final Status status;
    private final Authority authority;
}
