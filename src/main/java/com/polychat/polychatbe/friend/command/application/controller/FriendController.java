package com.polychat.polychatbe.friend.command.application.controller;

import com.polychat.polychatbe.friend.command.application.dto.FriendUserDTO;
import com.polychat.polychatbe.friend.command.application.service.FriendApplicationService;
import com.polychat.polychatbe.friend.command.domain.service.FriendService;
import com.polychat.polychatbe.friend.query.service.FriendSearchService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1")
public class FriendController {

    //private FriendService friendService;
    private FriendSearchService friendSearchService;
    private FriendApplicationService friendApplicationService;

    public FriendController(FriendSearchService friendSearchService, FriendApplicationService friendApplicationService) {
        this.friendSearchService = friendSearchService;
        this.friendApplicationService = friendApplicationService;
    }


    //    @GetMapping("friend")
//    public FriendResponseDTO getFriend(@RequestParam Long id){
//        return friendSearchService.findFriendByUserId()
//    }

//    @GetMapping("friend/")
//

    @Operation(summary = "친구 등록", description = "두 유저를 친구로 등록합니다.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("friend")
    public void addFriend(@RequestBody FriendUserDTO friendUserDTO) throws Exception {

        friendApplicationService.addFriend(friendUserDTO);

    }

    @Operation(summary = "친구 삭제", description = "두 유저의 친구관계를 삭제합니다.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("friend")
    public void deleteFriend(@RequestBody FriendUserDTO friendUserDTO){

        friendApplicationService.deleteFriend(friendUserDTO);
    }


}
