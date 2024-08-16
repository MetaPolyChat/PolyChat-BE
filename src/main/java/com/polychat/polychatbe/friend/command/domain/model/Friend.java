package com.polychat.polychatbe.friend.command.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_FRIEND")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer friendId;

    @Embedded
    @AttributeOverride(name="friendUserId", column = @Column(name="USER1"))
    private FriendUserId user1;
    @Embedded
    @AttributeOverride(name="friendUserId", column = @Column(name="USER2"))
    private FriendUserId user2;
    //private LocalDateTime requestTime;

    protected Friend() {}

    public Friend(FriendUserId user1, FriendUserId user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public FriendUserId getUser1() {
        return user1;
    }

    public FriendUserId getUser2() {
        return user2;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "friendId=" + friendId +
                ", user1=" + user1 +
                ", user2=" + user2 +
                '}';
    }
}
