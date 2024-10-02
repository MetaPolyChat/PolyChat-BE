package com.polychat.polychatbe.friend.query.service;

import com.polychat.polychatbe.friend.command.domain.model.FriendUserId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
public class TwoFriendUserVO {
    private final FriendUserId user1;
    private final FriendUserId user2;
}
