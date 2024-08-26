package com.polychat.polychatbe.friendRequest.query.repository;

import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import com.polychat.polychatbe.friendRequest.query.dto.FriendRequestInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRequestSearchRepository extends JpaRepository<FriendRequest, Long> {
    List<FriendRequest> findBySender(int sender);
}
