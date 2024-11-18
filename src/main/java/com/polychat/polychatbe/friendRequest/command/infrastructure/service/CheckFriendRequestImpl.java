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
        
        if(blockListQueryService.findSingleBlockList(
                friendRequest.getSender(), friendRequest.getReceiver()
        )!=null || blockListQueryService.findSingleBlockList(
                friendRequest.getReceiver(), friendRequest.getSender()) !=null  
        ) { //차단 목록에 있음
            throw new IllegalStateException("차단된 유저들끼리 친구 신청을 할 수 없습니다.");
        }

    }
}
