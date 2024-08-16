package com.polychat.polychatbe.friendRequest.command.application.dto;

import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;

public class FriendRequestStatusDTO {

    private Integer friendRequestId;
    private RequestStatus status;

    public FriendRequestStatusDTO() {}

    public FriendRequestStatusDTO(Integer friendRequestId, RequestStatus status) {
        this.friendRequestId = friendRequestId;
        this.status = status;
    }

    public Integer getFriendRequestId() {
        return friendRequestId;
    }

    public void setFriendRequestId(Integer friendRequestId) {
        this.friendRequestId = friendRequestId;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FriendRequestStatusDTO{" +
                "friendRequestId=" + friendRequestId +
                ", status=" + status +
                '}';
    }
}
