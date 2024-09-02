package com.polychat.polychatbe.friend.query.dto;

import lombok.Data;

@Data
public class FriendUserInfoDTO {
    private final int friendUserId;
    private final String friendName;
    private final String userDescription;
    private final String friendImage;

}
