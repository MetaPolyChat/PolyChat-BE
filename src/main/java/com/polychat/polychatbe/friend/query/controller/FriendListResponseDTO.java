package com.polychat.polychatbe.friend.query.controller;

import lombok.Data;

@Data
public class FriendListResponseDTO {
    private final int friendUserId;
    private final String friendName;
    private final String userDescription;
    private final String friendImage;

}
