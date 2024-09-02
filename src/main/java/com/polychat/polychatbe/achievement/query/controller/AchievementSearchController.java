package com.polychat.polychatbe.achievement.query.controller;

import com.polychat.polychatbe.achievement.query.dto.AchievementResponseDTO;
import com.polychat.polychatbe.achievement.query.service.AchievementSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AchievementSearchController {

    AchievementSearchService achievementSearchService;

    public AchievementSearchController(AchievementSearchService achievementSearchService) {
        this.achievementSearchService = achievementSearchService;
    }

    @GetMapping("achievement")
    public List<AchievementResponseDTO> getAllAchievement() {
        List<AchievementResponseDTO> achievementList = achievementSearchService.findAllAchievement();

        return achievementList;

    }

    @GetMapping("achievement/{id}")
    public AchievementResponseDTO getAchievementById(@PathVariable long id) {
        AchievementResponseDTO achievement = achievementSearchService.findAchievementById(id);

        return achievement;
    }

}
