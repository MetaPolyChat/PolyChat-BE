package com.polychat.polychatbe.blockList.command.domain.repository;

import com.polychat.polychatbe.blockList.command.domain.model.BlockList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockListRepository extends JpaRepository<BlockList, Long> {

    List<BlockList> findByUserId(Long userId);

    List<BlockList> findByBlockedUserId(Long blockedUserId);

    BlockList findByUserIdAndBlockedUserId(Long userId, Long blockedId);

}
