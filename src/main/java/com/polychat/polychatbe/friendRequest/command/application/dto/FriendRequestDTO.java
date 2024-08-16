package com.polychat.polychatbe.friendRequest.command.application.dto;

import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;

public class FriendRequestDTO {

    private int senderId;
    private int receiverId;
    private RequestStatus status;

    public FriendRequestDTO() {}

    public FriendRequestDTO(int senderId, int receiverId, RequestStatus status) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.status = status;
    }
    
    public FriendRequestDTO(int senderId, int receiverId) {
        this(senderId, receiverId, RequestStatus.PENDING);
    }


    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FriendRequestDTO{" +
                "senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", status=" + status +
                '}';
    }
}
