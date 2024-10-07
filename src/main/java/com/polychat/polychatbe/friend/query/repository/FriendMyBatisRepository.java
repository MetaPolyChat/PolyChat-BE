package com.polychat.polychatbe.friend.query.repository;

import com.polychat.polychatbe.friend.command.domain.model.Friend;
import com.polychat.polychatbe.friend.command.domain.model.FriendUserId;
import com.polychat.polychatbe.friend.query.dto.FriendUserInfoDTO;
import com.polychat.polychatbe.friend.query.dto.FriendResponseDTO;
import com.polychat.polychatbe.friend.query.service.TwoFriendUserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FriendMyBatisRepository {

    Optional<FriendResponseDTO> findByTwoUser(TwoFriendUserVO twoUserId);

    List<FriendUserInfoDTO> findOneUserFriend(FriendUserId userId);

    FriendResponseDTO findByFriendId(long friendId);

    List<FriendResponseDTO> findAllFriend();
}
