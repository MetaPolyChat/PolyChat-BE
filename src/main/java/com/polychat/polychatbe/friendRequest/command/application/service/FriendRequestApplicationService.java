package com.polychat.polychatbe.friendRequest.command.application.service;

import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestDTO;
import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestStatusDTO;
import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import com.polychat.polychatbe.friendRequest.command.domain.repository.FriendRequestRepository;
import com.polychat.polychatbe.friendRequest.command.domain.service.CheckFriendRequest;
import com.polychat.polychatbe.friendRequest.command.domain.service.FriendRequestService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FriendRequestApplicationService {

    private FriendRequestRepository friendRequestRepository;
    private FriendRequestService friendRequestService;
    private CheckFriendRequest checkFriendRequest;

    public FriendRequestApplicationService(FriendRequestRepository friendRequestRepository,
                                           FriendRequestService friendRequestService,
                                           CheckFriendRequest checkFriendRequest) {
        this.friendRequestRepository = friendRequestRepository;
        this.friendRequestService = friendRequestService;
        this.checkFriendRequest = checkFriendRequest;
    }

    @Transactional
    public void addFriendRequest(FriendRequestDTO friendRequestInfo) {
        friendRequestService.addFriendRequest(friendRequestInfo);
    }

    @Transactional
    public void updateFriendRequestStatus(FriendRequestStatusDTO friendRequestStatusInfo) {
        friendRequestService.updateFriendRequestStatus(friendRequestStatusInfo);
    }

    @Transactional
    public void acceptFriendRequest(long friendRequestId) {

        FriendRequest request = friendRequestRepository.findById(friendRequestId)
                        .orElseThrow(()->new NoSuchElementException("해당하는 요청이 존재하지 않습니다."));

        checkFriendRequest.validationRequest(request);
        friendRequestService.approveFriendRequest(request);
    }
}