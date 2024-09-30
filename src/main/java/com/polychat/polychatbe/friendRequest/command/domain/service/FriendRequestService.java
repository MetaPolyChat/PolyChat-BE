package com.polychat.polychatbe.friendRequest.command.domain.service;

import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestDTO;
import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestStatusDTO;
import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;
import com.polychat.polychatbe.friendRequest.command.domain.repository.FriendRequestRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class FriendRequestService {

    private FriendRequestRepository friendRequestRepository;
    private ApplicationEventPublisher eventPublisher;

    public FriendRequestService(FriendRequestRepository friendRequestRepository, ApplicationEventPublisher eventPublisher) {
        this.friendRequestRepository = friendRequestRepository;
        this.eventPublisher = eventPublisher;
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
    public void approveFriendRequest(long requestId) {
        FriendRequest request = friendRequestRepository.findById(requestId)
                .orElseThrow(() -> new NoSuchElementException("Friend request not found"));

        request.setStatus(RequestStatus.ACCEPTED);
        friendRequestRepository.save(request);

        // 이벤트 발행
        eventPublisher.publishEvent(new FriendRequestApprovedEvent(request.getSender(), request.getReceiver()));
    }

    @Transactional
    public void updateFriendRequestStatus(FriendRequestStatusDTO friendRequestStatusDTO){

        FriendRequest friendRequest = friendRequestRepository.findById(friendRequestStatusDTO.getFriendRequestId())
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 친구 신청입니다."));

        friendRequest.setStatus(friendRequestStatusDTO.getStatus());
    }

    @Transactional
    public void deleteFriendRequest(long friendRequestId){
        friendRequestRepository.deleteById(friendRequestId);
    }

}
