package com.polychat.polychatbe.achievement.command.application.controller;

import com.polychat.polychatbe.achievement.command.application.dto.AchievementRequest;
import com.polychat.polychatbe.achievement.command.application.service.AchievementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1")
@Tag(name = "업적 API", description = "업적을 등록, 수정, 삭제하는 API")

public class AchievementController {

    private AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @Operation(summary = "업적 등록", description = "새로운 업적을 등록합니다.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/achievement")
    public void addAchievement(@RequestBody AchievementRequest achievement) {

        if (achievement.getAchievementId()!=null){
            throw new RuntimeException("비정상적인 접근");
        }
        achievementService.addAchievement(achievement);

    }

    @Operation(summary = "업적 변경", description = "지정한 업적의 내용을 변경합니다.")
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/achievement/{id}")
    public void updateAchievement(@RequestBody AchievementRequest achievement, @PathVariable long id) {

        achievement.setAchievementId(id);
        achievementService.updateAchievement(achievement);
    }

    @Operation(summary = "업적 삭제", description = "지정한 업적을 삭제합니다.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/achievement/{id}")
    public void deleteAchievement(@PathVariable long id){
        achievementService.deleteAchievement(id);
    }

}
