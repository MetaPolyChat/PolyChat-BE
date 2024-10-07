package com.polychat.polychatbe.friend.command.domain.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class FriendUserId {

    private long friendUserId;

    protected FriendUserId() {}

    public FriendUserId(long friendUserId) {
        this.friendUserId = friendUserId;
    }

    public long getFriendUserId() {
        return friendUserId;
    }

    @Override
    public String toString() {
        return "FriendUserId{" +
                "friendUserId=" + friendUserId +
                '}';
    }
}
