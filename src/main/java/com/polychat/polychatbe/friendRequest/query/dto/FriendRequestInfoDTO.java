package com.polychat.polychatbe.friendRequest.query.dto;

import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequestInfoDTO {

    private long requestId;
    private int sender;
    private int receiver;
    private RequestStatus status;


    public FriendRequestInfoDTO(FriendRequest friendRequest){
        this(
                friendRequest.getFriendRequestId(),
                friendRequest.getSender(),
                friendRequest.getReceiver(),
                friendRequest.getStatus()
        );
    }

}
