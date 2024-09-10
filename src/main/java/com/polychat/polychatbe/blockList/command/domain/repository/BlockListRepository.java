package com.polychat.polychatbe.blockList.command.domain.repository;

import com.polychat.polychatbe.blockList.command.domain.model.BlockList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BlockListRepository extends JpaRepository<BlockList, Long> {

    Optional<List<BlockList>> findByUserId(Long userId);

    Optional<List<BlockList>> findByBlockedUserId(Long blockedUserId);

    Optional<BlockList> findByUserIdAndBlockedUserId(Long userId, Long blockedId);

}
