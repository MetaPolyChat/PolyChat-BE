package com.polychat.polychatbe.friendRequest.command.domain.service;

import com.polychat.polychatbe.friend.command.domain.service.FriendService;
import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestDTO;
import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestStatusDTO;
import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;
import com.polychat.polychatbe.friendRequest.command.domain.repository.FriendRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendRequestService {

    private FriendRequestRepository friendRequestRepository;
    private FriendService friendService;

    public FriendRequestService(FriendRequestRepository friendRequestRepository, FriendService friendService) {
        this.friendRequestRepository = friendRequestRepository;
        this.friendService = friendService;
    }

    @Transactional
    public void addFriendRequest(FriendRequestDTO friendRequestInfo) {

        if (friendRequestInfo.getSenderId() == friendRequestInfo.getReceiverId()){
            throw new IllegalArgumentException("자신을 친구 신청할 수 없습니다.");
        }

        FriendRequest friendRequest = new FriendRequest(
                friendRequestInfo.getSenderId(),
                friendRequestInfo.getReceiverId(),
                friendRequestInfo.getStatus()
        );

        friendRequestRepository.save(friendRequest);
    }

    @Transactional
    public void updateFriendRequestStatus(FriendRequestStatusDTO friendRequestStatusDTO){

        FriendRequest friendRequest = friendRequestRepository.findById(friendRequestStatusDTO.getFriendRequestId())
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 친구 신청입니다."));

        friendRequest.setStatus(friendRequestStatusDTO.getStatus());
    }

    @Transactional
    public void deleteFriendRequest(int friendRequestId){
        friendRequestRepository.deleteById(friendRequestId);
    }

}
