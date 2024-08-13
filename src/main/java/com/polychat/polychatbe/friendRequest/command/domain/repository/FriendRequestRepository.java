package com.polychat.polychatbe.friendRequest.command.domain.repository;

import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Integer> {
}
