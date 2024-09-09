package com.polychat.polychatbe.friend.command.application.controller;

import com.polychat.polychatbe.friend.command.application.dto.FriendUserDTO;
import com.polychat.polychatbe.friend.command.application.service.FriendApplicationService;
import com.polychat.polychatbe.friend.command.domain.service.FriendService;
import com.polychat.polychatbe.friend.query.service.FriendSearchService;
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
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("friend")
    public void addFriend(@RequestBody FriendUserDTO friendUserDTO) throws Exception {

        friendApplicationService.addFriend(friendUserDTO);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("friend")
    public void deleteFriend(@RequestBody FriendUserDTO friendUserDTO){

        friendApplicationService.deleteFriend(friendUserDTO);
    }


}
