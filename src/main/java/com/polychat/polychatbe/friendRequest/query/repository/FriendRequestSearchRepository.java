package com.polychat.polychatbe.friendRequest.query.repository;

import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRequestSearchRepository extends JpaRepository<FriendRequest, Integer> {
}
