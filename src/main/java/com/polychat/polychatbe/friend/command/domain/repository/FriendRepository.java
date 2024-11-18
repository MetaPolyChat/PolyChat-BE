package com.polychat.polychatbe.friend.command.domain.repository;

import com.polychat.polychatbe.friend.command.domain.model.Friend;
import com.polychat.polychatbe.friend.command.domain.model.FriendUserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {

    void deleteByUser1AndUser2(FriendUserId user1, FriendUserId user2);
    Friend findByUser1AndUser2(FriendUserId user1, FriendUserId user2);
}
