package com.polychat.polychatbe.friendRequest.query.dto;

import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFriendRequestDTO {
    private long receiverId;
    private String userName;
    private RequestStatus status;

    public UserFriendRequestDTO(FriendRequest friendRequestInfo){
        this(
                friendRequestInfo.getReceiver(),
                // user 이름 조회 기능 추가 예정
                null,
                friendRequestInfo.getStatus()
        );
    }
}
