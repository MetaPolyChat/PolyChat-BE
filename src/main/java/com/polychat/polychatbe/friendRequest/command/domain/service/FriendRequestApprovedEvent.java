package com.polychat.polychatbe.friendRequest.command.domain.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FriendRequestApprovedEvent {
    private final long senderId;
    private final long receiverId;
}
