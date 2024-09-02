package com.polychat.polychatbe.friend.command.domain.service;

import com.polychat.polychatbe.friend.command.domain.repository.FriendRepository;
import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FriendRequestAcceptService {

    private FriendRepository friendRepository;
    private FriendService friendService;

    public FriendRequestAcceptService(FriendRepository friendRepository, FriendService friendService) {
        this.friendRepository = friendRepository;
        this.friendService = friendService;
    }

    @Transactional
    public void acceptFriendRequest(FriendRequest friendRequest) {

        if (friendRequest.getStatus() != RequestStatus.ACCEPTED) {
            throw new IllegalArgumentException("승인되지 않은 친구 신청입니다.");
        }

        int user1=friendRequest.getSender();
        int user2=friendRequest.getReceiver();

        friendService.addFriend(user1, user2);
        friendService.addFriend(user2, user1);
    }


}
