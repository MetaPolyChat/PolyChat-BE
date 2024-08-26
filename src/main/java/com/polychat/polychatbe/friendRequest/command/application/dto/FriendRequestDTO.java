package com.polychat.polychatbe.friendRequest.command.application.dto;

import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class FriendRequestDTO {

    private final int senderId;
    private final int receiverId;
    private final RequestStatus status;

}
