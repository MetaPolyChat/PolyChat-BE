package com.polychat.polychatbe.achievement.command.application.controller;

import com.polychat.polychatbe.achievement.command.application.dto.AchievementRequest;
import com.polychat.polychatbe.achievement.command.application.service.AchievementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1")
public class AchievementController {

    private AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/achievement")
    public void addAchievement(@RequestBody AchievementRequest achievement) {

        if (achievement.getAchievementId()!=null){
            throw new RuntimeException("비정상적인 접근");
        }
        achievementService.addAchievement(achievement);

    }


    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/achievement/{id}")
    public void updateAchievement(@RequestBody AchievementRequest achievement, @PathVariable long id) {

        achievement.setAchievementId(id);
        achievementService.updateAchievement(achievement);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/achievement/{id}")
    public void deleteAchievement(@PathVariable long id){
        achievementService.deleteAchievement(id);
    }

}
