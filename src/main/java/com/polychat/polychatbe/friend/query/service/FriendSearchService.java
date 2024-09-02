package com.polychat.polychatbe.friend.query.service;

import com.polychat.polychatbe.friend.query.dto.FriendResponseDTO;
import com.polychat.polychatbe.friend.command.application.dto.FriendUserDTO;
import com.polychat.polychatbe.friend.command.domain.model.Friend;
import com.polychat.polychatbe.friend.command.domain.model.FriendUserId;
import com.polychat.polychatbe.friend.query.dto.FriendUserInfoDTO;
import com.polychat.polychatbe.friend.query.repository.FriendMyBatisRepository;
import com.polychat.polychatbe.friend.query.repository.FriendSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendSearchService {

    private FriendSearchRepository friendSearchRepository;
    private FriendMyBatisRepository friendMyBatisRepository;

    public FriendSearchService(FriendSearchRepository friendSearchRepository) {
        this.friendSearchRepository = friendSearchRepository;
    }

    public List<FriendResponseDTO> findAllFriend() {
        return friendMyBatisRepository.findAllFriend();
    }

    public FriendResponseDTO findFriendById(int friendId){
        return friendMyBatisRepository.findByFriendId(friendId);

    }

    public List<FriendUserInfoDTO> findUserFriend(int userId) {

        return friendMyBatisRepository.findOneUserFriend(new FriendUserId(userId));
    }

    public FriendResponseDTO findFriendByUserId(int user1, int user2){
        Friend friendInfo = friendSearchRepository.findByUser1AndUser2(
                new FriendUserId(user1),
                new FriendUserId(user2)
        );
        return new FriendResponseDTO(
                friendInfo.getFriendId(),
                friendInfo.getUser1().getFriendUserId(),
                friendInfo.getUser2().getFriendUserId()
        );
    }

    public FriendResponseDTO findFriendByUserInfo(FriendUserDTO friendUserInfo) {
        return this.findFriendByUserId(friendUserInfo.getUser1(), friendUserInfo.getUser2());
    }

}
