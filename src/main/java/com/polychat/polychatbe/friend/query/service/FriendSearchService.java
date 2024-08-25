package com.polychat.polychatbe.friend.query.service;

import com.polychat.polychatbe.friend.command.application.dto.FriendResponseDTO;
import com.polychat.polychatbe.friend.command.application.dto.FriendUserDTO;
import com.polychat.polychatbe.friend.command.domain.model.Friend;
import com.polychat.polychatbe.friend.command.domain.model.FriendUserId;
import com.polychat.polychatbe.friend.query.repository.FriendSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendSearchService {

    private FriendSearchRepository friendSearchRepository;

    public FriendSearchService(FriendSearchRepository friendSearchRepository) {
        this.friendSearchRepository = friendSearchRepository;
    }

    public List<FriendResponseDTO> findAllFriend() {
        List<Friend> friendList = friendSearchRepository.findAll();

        return friendList.stream()
                .map((friend)->new FriendResponseDTO(
                        friend.getFriendId(),
                        friend.getUser1().getFriendUserId(),
                        friend.getUser2().getFriendUserId()
                )).toList();
    }

    public FriendResponseDTO findFriendById(int friendId){
        Friend friendInfo = friendSearchRepository.findById(friendId).orElseThrow(()->new IllegalArgumentException("존재하지 않는 번호입니다."));
        return new FriendResponseDTO(
                friendInfo.getFriendId(),
                friendInfo.getUser1().getFriendUserId(),
                friendInfo.getUser2().getFriendUserId()
        );

    }

    public List<FriendResponseDTO> findUserFriend(int userId){
        List <Friend> friendList= friendSearchRepository.findByUser1(
                new FriendUserId(userId)
        );

        return friendList.stream()
                .map((friend)->new FriendResponseDTO(
                        friend.getFriendId(),
                        friend.getUser1().getFriendUserId(),
                        friend.getUser2().getFriendUserId()
                )).toList();
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

    public FriendResponseDTO findFriendByUserInfo(FriendUserDTO frienduserInfo) {
        return this.findFriendByUserId(frienduserInfo.getUser1(), frienduserInfo.getUser2());
    }

}
