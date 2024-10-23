package com.polychat.polychatbe.friendBoard.repository;

import com.polychat.polychatbe.friendBoard.entity.friendBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendBoardRepository extends JpaRepository<friendBoard, Long> {
}
