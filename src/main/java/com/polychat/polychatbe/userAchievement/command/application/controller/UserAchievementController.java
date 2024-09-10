package com.polychat.polychatbe.userAchievement.command.application.controller;

import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestDTO;
import com.polychat.polychatbe.friendRequest.command.application.dto.FriendRequestStatusDTO;
import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;
import com.polychat.polychatbe.userAchievement.command.application.dto.UserAchievementRegistDTO;
import com.polychat.polychatbe.userAchievement.command.application.service.UserAchievementService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public class UserAchievementController {

    UserAchievementService userAchievementService;

    public UserAchievementController(UserAchievementService userAchievementService) {
        this.userAchievementService = userAchievementService;
    }

    @Operation(summary = "유저 업적 등록", description = "유저가 달성한 업적을 추가합니다.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("userAchievement")
    public void addUserAchievement(UserAchievementRegistDTO userAchievement) {
        userAchievementService.addUserAchievement(userAchievement);
    }

    @Operation(summary = "유저 업적 변경", description = "유저가 달성한 업적을 다른 업적으로 변경합니다.")
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("userAchievement/{id}")
    public void updateRequestStats(@PathVariable long id, @RequestBody long achievementId){

        UserAchievementRegistDTO userAchievementInfo = new UserAchievementRegistDTO();

        //userAchievementService.modifyOneUserAchievement();
    }

    @Operation(summary = "유저 업적 삭제", description = "지정한 유저 업적을 달성하지 않은 상태로 변경합니다.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("userAchievement/{id}")
    public void deleteUserAchievement(@PathVariable long id){
        userAchievementService.deleteUserAchievement(id);
    }
}
