package com.polychat.polychatbe.friend.query.repository;

import com.polychat.polychatbe.friend.command.domain.model.Friend;
import com.polychat.polychatbe.friend.command.domain.model.FriendUserId;
import com.polychat.polychatbe.friend.query.dto.FriendUserInfoDTO;
import com.polychat.polychatbe.friend.query.dto.FriendResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FriendMyBatisRepository {

    Friend findByTwoUser(FriendUserId user1, FriendUserId user2);

    List<FriendUserInfoDTO> findOneUserFriend(FriendUserId userId);

    FriendResponseDTO findByFriendId(long friendId);

    List<FriendResponseDTO> findAllFriend();
}
