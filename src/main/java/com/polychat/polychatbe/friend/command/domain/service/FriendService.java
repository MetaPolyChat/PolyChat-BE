package com.polychat.polychatbe.friend.command.domain.service;

import com.polychat.polychatbe.friend.command.application.dto.FriendUserDTO;
import com.polychat.polychatbe.friend.command.domain.model.Friend;
import com.polychat.polychatbe.friend.command.domain.model.FriendUserId;
import com.polychat.polychatbe.friend.command.domain.repository.FriendRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FriendService {

    private FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public void addFriend(long user1, long user2) {

        if(user1==user2){
            throw new IllegalArgumentException("자신을 친구로 추가할 수 없습니다.");
        }

        // 서로이웃 형식처럼 양방향으로 추가
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

    public void deleteFriendById(long friendId){
        friendRepository.deleteById(friendId);
    }

    public void deleteFriendByUserId(long user1, long user2) {

        // 추가와 마찬가지로 양방향 삭제
        friendRepository.deleteByUser1AndUser2(
                new FriendUserId(user1),
                new FriendUserId(user2)
        );

        friendRepository.deleteByUser1AndUser2(
                new FriendUserId(user2),
                new FriendUserId(user1)
        );
    }

}
