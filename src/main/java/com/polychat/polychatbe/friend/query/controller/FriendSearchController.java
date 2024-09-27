package com.polychat.polychatbe.friend.query.controller;

import com.polychat.polychatbe.common.SearchCriteriaInfo;
import com.polychat.polychatbe.friend.query.dto.FriendResponseDTO;
import com.polychat.polychatbe.friend.query.dto.FriendUserInfoDTO;
import com.polychat.polychatbe.friend.query.dto.OneUserFriendResponseDTO;
import com.polychat.polychatbe.friend.query.service.FriendSearchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.List;

@RestController
@Tag(name = "친구 조회 API", description = "친구 목록을 조회하는 API")
public class FriendSearchController {

    private FriendSearchService friendSearchService;

    @GetMapping("friend")
    public ResponseEntity<List<FriendResponseDTO>> getAllFriend(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(friendSearchService.findAllFriend()
                );
    }



    @GetMapping("friend/{userId}")
    public ResponseEntity<OneUserFriendResponseDTO> getUserFriends(
            @PathVariable int userId, @ModelAttribute SearchCriteriaInfo searchCriteriaInfo){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        List<FriendUserInfoDTO> friendUsers = friendSearchService.findUserFriend(userId);

        OneUserFriendResponseDTO friendResponse =
                new OneUserFriendResponseDTO(userId, friendUsers);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(friendResponse);
    }


}
