package com.polychat.polychatbe.user.query.controller;

import com.polychat.polychatbe.common.PageItemResponse;
import com.polychat.polychatbe.user.query.dto.UserResponseDTO;
import com.polychat.polychatbe.user.query.service.UserSearchService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class UserSearchController {

    private UserSearchService userSearchService;

    public UserSearchController(UserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }

    @GetMapping("/admin/user")
    public ResponseEntity<List<UserResponseDTO>> findAllUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        return new ResponseEntity<>(
                userSearchService.findAllUser(),
                headers, HttpStatus.OK);

    }

}
