package com.polychat.polychatbe.blockList.command.application.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlockUserDTO {
    private Long userId;
    private Long blockedUserId;

    public BlockUserDTO() {
    }

    public BlockUserDTO(Long userId, Long blockedUserId) {
        this.userId = userId;
        this.blockedUserId = blockedUserId;
    }

    @Override
    public String toString() {
        return "BlockUserDTO{" +
                "userId=" + userId +
                ", blockedUserId=" + blockedUserId +
                '}';
    }
}
