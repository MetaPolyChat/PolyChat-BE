package com.polychat.polychatbe.friend.command.application.dto;

import lombok.Data;

@Data
public class FriendResponseDTO {
    //친구 db의 primary key에 대응하는 변수
    private final long friendId;
    
    private final int userId1;
    private final int userId2;

}
