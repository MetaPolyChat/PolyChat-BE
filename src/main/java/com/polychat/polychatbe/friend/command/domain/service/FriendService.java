package com.polychat.polychatbe.friend.command.domain.service;

import com.polychat.polychatbe.friend.command.application.dto.FriendResponseDTO;
import com.polychat.polychatbe.friend.command.domain.model.Friend;
import com.polychat.polychatbe.friend.command.domain.model.FriendUserId;
import com.polychat.polychatbe.friend.command.domain.repository.FriendRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendService {

    private FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
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

        Friend friendInfo2 = new Friend(
                new FriendUserId(user2),
                new FriendUserId(user1)
        );

        friendRepository.save(friendInfo1);
        friendRepository.save(friendInfo2);
    }

    @Transactional
    public void deleteFriend(int user1, int user2) {

        friendRepository.deleteByUser1AndUser2(
                new FriendUserId(user1),
                new FriendUserId(user2)
        );
    }


//    public addFriend()
}
