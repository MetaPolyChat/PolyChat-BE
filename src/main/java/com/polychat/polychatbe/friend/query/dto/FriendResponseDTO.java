package com.polychat.polychatbe.friend.query.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FriendResponseDTO {
    //친구 db의 primary key에 대응하는 변수
    private final long friendId;
    
    private final long userId1;
    private final long userId2;

}
