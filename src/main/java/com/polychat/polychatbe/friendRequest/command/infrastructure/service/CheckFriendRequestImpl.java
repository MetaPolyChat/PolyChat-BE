package com.polychat.polychatbe.friendRequest.command.infrastructure.service;

import com.polychat.polychatbe.blockList.query.service.BlockListQueryService;
import com.polychat.polychatbe.friend.query.service.FriendSearchService;
import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import com.polychat.polychatbe.friendRequest.command.domain.service.CheckFriendRequest;
import org.springframework.stereotype.Service;

@Service
public class CheckFriendRequestImpl implements CheckFriendRequest {

    private FriendSearchService friendSearchService;
    private BlockListQueryService blockListQueryService;

    public CheckFriendRequestImpl(FriendSearchService friendSearchService, BlockListQueryService blockListQueryService) {
        this.friendSearchService = friendSearchService;
        this.blockListQueryService = blockListQueryService;
    }

    @Override
    public void validationRequest(FriendRequest friendRequest) {
        if(friendSearchService.findFriendByUserId(friendRequest.getSender(), friendRequest.getReceiver())!=null){
            // 이미 친구상태로 등록됨
            throw new IllegalStateException("이미 친구 상태로 등록되어 있습니다.");
        }

    }
}
