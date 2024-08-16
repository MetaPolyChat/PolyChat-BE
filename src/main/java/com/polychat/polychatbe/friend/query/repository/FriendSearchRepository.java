package com.polychat.polychatbe.friend.query.repository;

import com.polychat.polychatbe.friend.command.domain.model.Friend;
import com.polychat.polychatbe.friend.command.domain.model.FriendUserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendSearchRepository extends JpaRepository<Friend, Integer> {
    Friend findByUser1AndUser2(FriendUserId user1, FriendUserId user2);
}
