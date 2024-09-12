package com.polychat.polychatbe.blockList.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlockUserDTO {
    private Long id;
    private Long userId;
    private Long blockedUserId;
    private String createdAt;

    @Override
    public String toString() {
        return "BlockUserDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", blockedUserId=" + blockedUserId +
                ", createdAt=" + createdAt +
                '}';
    }
}
