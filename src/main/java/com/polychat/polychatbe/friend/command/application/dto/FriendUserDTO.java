package com.polychat.polychatbe.friend.command.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendUserDTO {

    @NotBlank(message = "친구 정보가 유효한지 확인해주세요.")
    private int user1;

    @NotBlank(message = "친구 정보가 유효한지 확인해주세요.")
    private int user2;
}
