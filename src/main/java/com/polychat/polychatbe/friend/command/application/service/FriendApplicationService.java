package com.polychat.polychatbe.friend.command.application.service;

import com.polychat.polychatbe.friend.command.application.dto.FriendUserDTO;
import com.polychat.polychatbe.friend.command.domain.service.FriendService;
import com.polychat.polychatbe.friend.query.service.FriendSearchService;
import com.polychat.polychatbe.friendRequest.command.domain.service.FriendRequestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendApplicationService {

    private FriendService friendService;
    private FriendSearchService friendSearchService;
    private FriendRequestService friendRequestService;


    public FriendApplicationService(FriendService friendService, FriendSearchService friendSearchService) {
        this.friendService = friendService;
        this.friendSearchService = friendSearchService;
    }

    @Transactional
    public void addFriend(FriendUserDTO friendRegistInfo) throws Exception {
        if(friendSearchService.findFriendByUserInfo(friendRegistInfo)!=null) {
            throw new Exception("이미 존재하는 친구");
        }

        friendService.addFriend(friendRegistInfo);
    }

    @Transactional
    public void deleteFriend(FriendUserDTO friendRegistInfo){
        friendService.deleteFriendByUserId(friendRegistInfo);
    }

}
