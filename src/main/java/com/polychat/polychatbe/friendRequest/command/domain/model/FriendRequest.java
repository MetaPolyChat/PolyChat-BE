package com.polychat.polychatbe.friendRequest.command.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "TBL_FRIEND_REQUEST")
@Getter
@ToString
public class FriendRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long friendRequestId;

    private int sender;
    private int receiver;
    //private LocalDateTime requestTime;

    @Enumerated(EnumType.ORDINAL)
    private RequestStatus status;

    protected FriendRequest() {}

    public FriendRequest(int sender, int receiver, RequestStatus status) {
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
