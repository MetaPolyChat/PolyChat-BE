package com.polychat.polychatbe.friend.command.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class FriendUserDTO {

    @NotBlank(message = "친구 정보가 유효한지 확인해주세요.")
    private final long user1;

    @NotBlank(message = "친구 정보가 유효한지 확인해주세요.")
    private final long user2;
}
