package com.polychat.polychatbe.friendRequest.command.application.controller;

import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestDTO;
import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestStatusDTO;
import com.polychat.polychatbe.friendRequest.command.application.service.FriendRequestApplicationService;
import com.polychat.polychatbe.friendRequest.command.domain.model.FriendRequest;
import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1")
@Tag(name = "친구 신청 API", description = "친구 신청에 대한 API")
public class FriendRequestController {

    FriendRequestApplicationService friendRequestApplicationService;

    public FriendRequestController(FriendRequestApplicationService friendRequestApplicationService) {
        this.friendRequestApplicationService = friendRequestApplicationService;
    }

    @Operation(summary = "친구 신청 등록", description = "다름 사람에게 친구 신청을 합니다.,")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("friendRequest")
    public void addFriendRequest(FriendRequestDTO friendRequestInfo) {
        friendRequestApplicationService.addFriendRequest(friendRequestInfo);
    }

    @Operation(summary = "친구 신청 수락", description = "친구 신청 요청을 수락합니다.")
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("friendRequest/accept/{id}")
    public void acceptFriendRequest(@PathVariable long id){
        friendRequestApplicationService.acceptFriendRequest(id);
    }

    @Operation(summary = "친구 신청 취소", description = "친구 신청을 취소합니다.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("friendRequest/{id}")
    public void cancelFriendRequest(@PathVariable long id){
        FriendRequestStatusDTO requestInfo = new FriendRequestStatusDTO(id, RequestStatus.CANCELED);
        friendRequestApplicationService.updateFriendRequestStatus(requestInfo);
    }


}
