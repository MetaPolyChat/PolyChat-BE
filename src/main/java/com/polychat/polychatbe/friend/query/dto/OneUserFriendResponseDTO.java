package com.polychat.polychatbe.friend.query.dto;

import lombok.Data;

import java.util.List;

@Data
public class OneUserFriendResponseDTO {
    private final int userId;
    private final List<FriendUserInfoDTO> friendUsers;
}
