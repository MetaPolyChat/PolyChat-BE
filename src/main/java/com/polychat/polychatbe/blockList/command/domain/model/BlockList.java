package com.polychat.polychatbe.blockList.command.domain.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity(name = "tbl_block_list")
public class BlockList {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column
    private Long userId;

    @Getter
    @Column
    private Long blockedUserId;

    @Getter
    @Column
    private LocalDateTime createdAt;

    public BlockList() {
    }

    public BlockList(Long userId, Long blockedUserId, LocalDateTime createdAt) {
        this.userId = userId;
        this.blockedUserId = blockedUserId;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "BlockList{" +
                "id=" + id +
                ", userId=" + userId +
                ", blockedUserId=" + blockedUserId +
                ", createdAt=" + createdAt +
                '}';
    }
}
