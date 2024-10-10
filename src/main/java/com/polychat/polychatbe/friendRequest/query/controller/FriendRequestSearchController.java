package com.polychat.polychatbe.friendRequest.query.controller;

import com.polychat.polychatbe.friend.query.dto.FriendUserInfoDTO;
import com.polychat.polychatbe.friend.query.dto.OneUserFriendResponseDTO;
import com.polychat.polychatbe.friendRequest.query.dto.UserFriendRequestDTO;
import com.polychat.polychatbe.friendRequest.query.service.FriendRequestSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

@RestController
//@RequestMapping("/api/v1")
@Tag(name = "친구 요청 검색 API", description = "친구 요청 목록을 검색하는 API")
public class FriendRequestSearchController {

    private FriendRequestSearchService friendRequestSearchService;

    public FriendRequestSearchController(FriendRequestSearchService friendRequestSearchService) {
        this.friendRequestSearchService = friendRequestSearchService;
    }


    @Operation(summary = "유저 친구 신청 목록 조회", description = "지정한 유저의 친구 신청 목록을 조회합니다.")
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
