package com.polychat.polychatbe.friendRequest.command.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_FRIEND_REQUEST")
public class FriendRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long friendRequestId;

    @Column
    private int sender;
    @Column
    private int receiver;
    //private LocalDateTime requestTime;

    @Enumerated(EnumType.ORDINAL)
    @Column
    private RequestStatus status;

    protected FriendRequest() {}

    public FriendRequest(int sender, int receiver, RequestStatus status) {
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
    }

    public Long getFriendRequestId() {
        return friendRequestId;
    }

    public int getSender() {
        return sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FriendRequest{" +
                "friendRequestId=" + friendRequestId +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", status=" + status +
                '}';
    }
}
