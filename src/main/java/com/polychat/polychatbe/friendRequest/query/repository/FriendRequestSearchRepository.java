package com.polychat.polychatbe.friendRequest.query.repository;

import com.polychat.polychatbe.friendRequest.query.dto.FriendRequestInfoDTO;
import com.polychat.polychatbe.friendRequest.query.dto.UserFriendRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FriendRequestSearchRepository {

    Optional<FriendRequestInfoDTO> findFriendRequestById(long requestId);

    List<UserFriendRequestDTO> findFriendRequestBySender(int sender);

    List<FriendRequestInfoDTO> findAllFriendRequest();



}
