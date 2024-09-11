package com.polychat.polychatbe.blockList.query.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BlockFindDTO {

    private Long id;

    private Long userId;

    private Long blockedUserId;

    private LocalDateTime createdAt;

    public BlockFindDTO() {
    }

    public BlockFindDTO(Long id, Long userId, Long blockedUserId, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.blockedUserId = blockedUserId;
        this.createdAt = createdAt;
    }


    @Override
    public String toString() {
        return "BlockFindDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", blockedUserId=" + blockedUserId +
                ", createdAt=" + createdAt +
                '}';
    }
}
