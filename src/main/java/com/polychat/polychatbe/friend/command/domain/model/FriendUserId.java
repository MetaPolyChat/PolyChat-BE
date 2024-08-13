package com.polychat.polychatbe.friend.command.domain.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class FriendUserId {

    private int friendUserId;

    protected FriendUserId() {}

    public FriendUserId(int friendUserId) {
        this.friendUserId = friendUserId;
    }

    public int getFriendUserId() {
        return friendUserId;
    }

    @Override
    public String toString() {
        return "FriendUserId{" +
                "friendUserId=" + friendUserId +
                '}';
    }
}
