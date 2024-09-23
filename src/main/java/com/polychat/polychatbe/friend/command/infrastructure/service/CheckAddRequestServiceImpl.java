package com.polychat.polychatbe.friend.command.infrastructure.service;

import com.polychat.polychatbe.friend.command.domain.service.CheckAddRequestService;
import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;
import com.polychat.polychatbe.friendRequest.command.domain.repository.FriendRequestRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CheckAddRequestServiceImpl implements CheckAddRequestService {

    FriendRequestRepository friendRequestRepository;

    public CheckAddRequestServiceImpl(FriendRequestRepository friendRequestRepository) {
        this.friendRequestRepository = friendRequestRepository;
    }

    @Override
    public boolean isExistRequest(long friendRequestId) {
        return friendRequestRepository.existsById((int) friendRequestId);
    }

    @Override
    public boolean isValidRequest(long friendRequestId) {
        FriendRequest friendRequest = friendRequestRepository.findById((int)friendRequestId).orElseThrow(
                NoSuchElementException::new);

        return friendRequest.getStatus()== RequestStatus.ACCEPTED;
    }
}
