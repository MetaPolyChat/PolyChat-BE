package com.polychat.polychatbe.friendRequest.command.application.dto;

import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequestStatusDTO {
    private Integer friendRequestId;
    private RequestStatus status;

}
