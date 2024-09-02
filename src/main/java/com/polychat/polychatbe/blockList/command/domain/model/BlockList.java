package com.polychat.polychatbe.blockList.command.domain.model;

import jakarta.persistence.*;
import lombok.Getter;

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

    public BlockList() {
    }

    public BlockList(Long blockedUserId, Long userId) {
        this.blockedUserId = blockedUserId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BlockList{" +
                "id=" + id +
                ", userId=" + userId +
                ", blockedUserId=" + blockedUserId +
                '}';
    }
}
