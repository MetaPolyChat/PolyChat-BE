package com.polychat.polychatbe.achievement.query.controller;

import com.polychat.polychatbe.achievement.query.dto.AchievementResponseDTO;
import com.polychat.polychatbe.achievement.query.service.AchievementSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "업적 조회 API", description = "업적 정보를 조회하는 API")
public class AchievementSearchController {

    AchievementSearchService achievementSearchService;

    public AchievementSearchController(AchievementSearchService achievementSearchService) {
        this.achievementSearchService = achievementSearchService;
    }

    @Operation(summary = "전체 업적 조회", description = "전체 업적 목록을 조회합니다.")
    @GetMapping("achievement")
    public List<AchievementResponseDTO> getAllAchievement() {
        List<AchievementResponseDTO> achievementList = achievementSearchService.findAllAchievement();

        return achievementList;

    }

    @Operation(summary = "업적 조회", description = "지정한 업적 정보를 조회합니다.")
    @GetMapping("achievement/{id}")
    public AchievementResponseDTO getAchievementById(@PathVariable long id) {
        AchievementResponseDTO achievement = achievementSearchService.findAchievementById(id);

        return achievement;
    }

}
