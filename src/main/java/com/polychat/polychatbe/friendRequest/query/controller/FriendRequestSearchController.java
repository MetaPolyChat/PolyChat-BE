package com.polychat.polychatbe.friendRequest.query.controller;

import com.polychat.polychatbe.friend.query.dto.FriendUserInfoDTO;
import com.polychat.polychatbe.friend.query.dto.OneUserFriendResponseDTO;
import com.polychat.polychatbe.friendRequest.query.dto.UserFriendRequestDTO;
import com.polychat.polychatbe.friendRequest.query.service.FriendRequestSearchService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

@RestController
//@RequestMapping("/api/v1")
public class FriendRequestSearchController {

    private FriendRequestSearchService friendRequestSearchService;

    public FriendRequestSearchController(FriendRequestSearchService friendRequestSearchService) {
        this.friendRequestSearchService = friendRequestSearchService;
    }



    @GetMapping("friendRequest/{userId}")
    private ResponseEntity<List<UserFriendRequestDTO>> getUserFriendRequestList(@RequestParam int userId) {
        // 한 유저가 신청한 친구 요청의 상태를 보는것

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        List<UserFriendRequestDTO> friendRequestInfoList = friendRequestSearchService.findFriendRequestBySender(userId);


        return ResponseEntity
                .ok()
                .headers(headers)
                .body(friendRequestInfoList);
    }
}
