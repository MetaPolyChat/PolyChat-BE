package com.polychat.polychatbe.friend.command.application.service;

import com.polychat.polychatbe.friend.command.application.dto.FriendUserDTO;
import com.polychat.polychatbe.friend.command.domain.model.FriendUserId;
import com.polychat.polychatbe.friend.command.domain.repository.FriendRepository;
import com.polychat.polychatbe.friend.command.domain.service.FriendService;
import com.polychat.polychatbe.friend.query.service.FriendSearchService;
import com.polychat.polychatbe.friendRequest.command.domain.service.FriendRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class FriendApplicationService {

    private FriendRepository friendRepository;
    private FriendService friendService;

    public FriendApplicationService(FriendRepository friendRepository, FriendService friendService) {
        this.friendRepository = friendRepository;
        this.friendService = friendService;
    }

    public boolean isFriend(long user1, long user2){
        return friendRepository.findByUser1AndUser2(
                new FriendUserId(user1), new FriendUserId(user2)
        )!=null;
    }

    @Transactional
    public void addFriend(FriendUserDTO friendRegistInfo){

        if(isFriend(friendRegistInfo.getUser1(), friendRegistInfo.getUser2())) {
            log.warn("user {} and user {} are already friend", friendRegistInfo.getUser1(), friendRegistInfo.getUser2());
            throw new RuntimeException("이미 존재하는 친구입니다");
        }

        log.info("try to add friend between user {} and user {}.",
                friendRegistInfo.getUser1(), friendRegistInfo.getUser2());
        friendService.addFriend(friendRegistInfo.getUser1(), friendRegistInfo.getUser2());
    }

    @Transactional
    public void deleteFriend(FriendUserDTO friendRegistInfo){
        friendService.deleteFriendByUserId(
                friendRegistInfo.getUser1(), friendRegistInfo.getUser2());
    }

}
