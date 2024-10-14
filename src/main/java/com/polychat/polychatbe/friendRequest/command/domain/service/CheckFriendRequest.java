package com.polychat.polychatbe.friendRequest.command.domain.service;

import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;

public interface CheckFriendRequest {

    void validationRequest(FriendRequest friendRequest);
}
