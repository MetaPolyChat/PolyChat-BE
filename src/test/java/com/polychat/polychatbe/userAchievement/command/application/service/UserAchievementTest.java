package com.polychat.polychatbe.userAchievement.command.application.service;

import com.polychat.polychatbe.userAchievement.command.application.dto.UserAchievementRegistDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserAchievementTest {

    @Autowired
    private UserAchievementService userAchievementService;

    @DisplayName("유저 업적 추가 테스트")
    @ParameterizedTest
    @CsvSource({"1,3", "2,2"})
    public void addTest(long userId, long achievementId){

        UserAchievementRegistDTO userAchievementInfo = new UserAchievementRegistDTO(userId, achievementId);

        Assertions.assertDoesNotThrow(
                ()->userAchievementService.addUserAchievement(userAchievementInfo)
        );
    }

    //중복 추가 시도 테스트 예정

    @DisplayName("특정유저 업적 변경 테스트")
    @ParameterizedTest
    @CsvSource({"1,3,1"})
    public void modifyAllUserAchievement(long userId, long beforeAchievementId, long afterAchievementId){
        userAchievementService.modifyOneUserAchievement(userId, beforeAchievementId, afterAchievementId);

    }

    // 존재하지 않는 것으로 변경 시도 테스트 예정

    @DisplayName("특정유저 업적 삭제 테스트")
    @ParameterizedTest
    @ValueSource(longs = {1, 2})
    public void deleteAllUserAchievement(long userAchievementId){
        Assertions.assertDoesNotThrow(
                ()->userAchievementService.deleteUserAchievement(userAchievementId)
        );
    }

    
}
