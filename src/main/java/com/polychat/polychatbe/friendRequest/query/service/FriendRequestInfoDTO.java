package com.polychat.polychatbe.friendRequest.query.service;

import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;

public class FriendRequestInfoDTO {

    private int requestId;
    private int sender;
    private int receiver;
    private RequestStatus status;

    public FriendRequestInfoDTO(){}

    public FriendRequestInfoDTO(int requestId, int sender, int receiver, RequestStatus status) {
        this.requestId = requestId;
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FriendRequestInfoDTO{" +
                "requestId=" + requestId +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", status=" + status +
                '}';
    }
}
