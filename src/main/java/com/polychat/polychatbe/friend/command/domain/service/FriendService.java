package com.polychat.polychatbe.friend.command.domain.service;

import com.polychat.polychatbe.friend.command.application.dto.FriendUserDTO;
import com.polychat.polychatbe.friend.command.domain.model.Friend;
import com.polychat.polychatbe.friend.command.domain.model.FriendUserId;
import com.polychat.polychatbe.friend.command.domain.repository.FriendRepository;
import com.polychat.polychatbe.friend.query.service.FriendSearchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendService {

    private final FriendSearchService friendSearchService;
    private FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository, FriendSearchService friendSearchService) {
        this.friendRepository = friendRepository;
        this.friendSearchService = friendSearchService;
    }

    @Transactional
    public void addFriend(int user1, int user2) {

        if(user1==user2){
            throw new IllegalArgumentException("자신을 친구로 추가할 수 없습니다.");
        }

        Friend friendInfo1 = new Friend(
                new FriendUserId(user1),
                new FriendUserId(user2)
        );

        friendRepository.save(friendInfo1);
    }

    @Transactional
    public void deleteFriendById(long friendId){
        friendRepository.deleteById(friendId);
    }

    @Transactional
    public void deleteFriendByUserId(int user1, int user2) {

        friendRepository.deleteByUser1AndUser2(
                new FriendUserId(user1),
                new FriendUserId(user2)
        );
    }

    @Transactional
    public void addFriend(FriendUserDTO friendUserDTO) {
        this.addFriend(friendUserDTO.getUser1(), friendUserDTO.getUser2());
    }

    @Transactional
    public void deleteFriendByUserId(FriendUserDTO friendUserDTO) {
        this.deleteFriendByUserId(friendUserDTO.getUser1(), friendUserDTO.getUser2());
    }
}
