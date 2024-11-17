package com.polychat.polychatbe.friendRequest.command.application.service;

import com.polychat.polychatbe.friend.command.application.dto.FriendUserDTO;
import com.polychat.polychatbe.friend.command.application.service.FriendApplicationService;
import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestDTO;
import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestStatusDTO;
import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import com.polychat.polychatbe.friendRequest.command.domain.repository.FriendRequestRepository;
import com.polychat.polychatbe.friendRequest.command.domain.service.CheckFriendRequest;
import com.polychat.polychatbe.friendRequest.command.domain.service.FriendRequestService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class FriendRequestApplicationService {

    private FriendRequestRepository friendRequestRepository;
    private FriendRequestService friendRequestService;
    private CheckFriendRequest checkFriendRequest;
    private FriendApplicationService friendApplicationService;


    public FriendRequestApplicationService(FriendRequestRepository friendRequestRepository, FriendRequestService friendRequestService, CheckFriendRequest checkFriendRequest, FriendApplicationService friendApplicationService) {
        this.friendRequestRepository = friendRequestRepository;
        this.friendRequestService = friendRequestService;
        this.checkFriendRequest = checkFriendRequest;
        this.friendApplicationService = friendApplicationService;
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
        log.info("try to accept friendRequest, friendRequestId:{}, sender:{}, receiver:{}",
                friendRequestId, request.getSender(), request.getSender());
        checkFriendRequest.validationRequest(request);
        friendApplicationService.addFriend(new FriendUserDTO(request.getSender(), request.getReceiver()));
        friendRequestRepository.delete(request);
        log.info("successfully accept friendRequest, friendRequestId:{}, sender:{}, receiver:{}",
                friendRequestId, request.getSender(), request.getReceiver());

    }
}