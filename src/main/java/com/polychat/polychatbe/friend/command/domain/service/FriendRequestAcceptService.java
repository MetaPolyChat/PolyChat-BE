package com.polychat.polychatbe.friend.command.domain.service;

import com.polychat.polychatbe.friendRequest.command.domain.service.FriendRequestApprovedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class FriendRequestAcceptService {

    private FriendService friendService;

    public FriendRequestAcceptService(FriendService friendService) {
        this.friendService = friendService;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleFriendRequestApproved(FriendRequestApprovedEvent event) {
        friendService.addFriend(event.getReceiverId(), event.getSenderId());
    }

}
