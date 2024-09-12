package com.polychat.polychatbe.userAchievement.query.controller;

import com.polychat.polychatbe.userAchievement.query.dto.OneUserAchievementDTO;
import com.polychat.polychatbe.userAchievement.query.service.UserAchievementSearchService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

public class UserAchievementSearchController {

    private UserAchievementSearchService userAchievementSearchService;

    public UserAchievementSearchController(UserAchievementSearchService userAchievementSearchService) {
        this.userAchievementSearchService = userAchievementSearchService;
    }

    @Operation(summary = "특정 유저 업적 목록 조회", description = "지정한 유저의 업적 목록을 조회합니다.")
    @GetMapping("userAchievement")
    public ResponseEntity<OneUserAchievementDTO> getAnnouncementList(@RequestParam long userId) {

        OneUserAchievementDTO oneUserAchievement = userAchievementSearchService.findOneUserAchievements(userId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(oneUserAchievement, headers, HttpStatus.OK);
    }
}
