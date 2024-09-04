package com.polychat.polychatbe.friendRequest.command.application.service;

import com.polychat.polychatbe.friend.command.domain.service.FriendRequestAcceptService;
import com.polychat.polychatbe.friend.query.service.FriendSearchService;
import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestDTO;
import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestStatusDTO;
import com.polychat.polychatbe.friendRequest.command.domain.service.FriendRequestService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FriendRequestApplicationService {

    private FriendRequestService friendRequestService;
    private FriendSearchService friendSearchService;
    private FriendRequestAcceptService friendRequestAcceptService;

    public FriendRequestApplicationService(FriendRequestService friendRequestService, FriendSearchService friendSearchService) {
        this.friendRequestService = friendRequestService;
        this.friendSearchService = friendSearchService;
    }

    @Transactional
    public void addFriendRequest(FriendRequestDTO friendRequestInfo){
        friendRequestService.addFriendRequest(friendRequestInfo);
    }

    @Transactional
    public void updateFriendRequestStatus(FriendRequestStatusDTO friendRequestStatusInfo){
        friendRequestService.updateFriendRequestStatus(friendRequestStatusInfo);
    }

    @Transactional
    public void acceptFriendRequest(FriendRequestDTO friendRequestInfo){

    }


}
