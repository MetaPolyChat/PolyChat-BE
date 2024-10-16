package com.polychat.polychatbe.user.query.controller;

import com.polychat.polychatbe.common.PageItemResponse;
import com.polychat.polychatbe.common.SearchCriteriaInfo;
import com.polychat.polychatbe.user.query.dto.UserDetailResponseDTO;
import com.polychat.polychatbe.user.query.dto.UserResponseDTO;
import com.polychat.polychatbe.user.query.service.UserSearchService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/admin/user/some")
    public ResponseEntity<PageItemResponse<UserResponseDTO>> findAllUserWithCriteria(
            @Valid @ModelAttribute SearchCriteriaInfo searchCriteria) {
        System.out.println(searchCriteria);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        return new ResponseEntity<>(
                new PageItemResponse<>(
                        userSearchService.countAll(),
                        userSearchService.findUsersWithCriteria(searchCriteria)),
                headers, HttpStatus.OK);

    }

    @GetMapping("user/{id}")
    public ResponseEntity<UserDetailResponseDTO> findUser(@PathVariable long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        return new ResponseEntity<>(
                userSearchService.findUserById(id),headers, HttpStatus.OK
        );
    }

}
