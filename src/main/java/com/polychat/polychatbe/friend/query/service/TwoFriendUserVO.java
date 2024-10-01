package com.polychat.polychatbe.friend.query.service;

import com.polychat.polychatbe.friend.command.domain.model.FriendUserId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TwoFriendUserVO {
    private final FriendUserId userId1;
    private final FriendUserId userId2;
}
