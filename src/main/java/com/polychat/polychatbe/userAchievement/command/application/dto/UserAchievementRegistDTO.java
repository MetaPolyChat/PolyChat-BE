package com.polychat.polychatbe.userAchievement.command.application.dto;

import com.polychat.polychatbe.userAchievement.command.domain.aggregate.UserAchievement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAchievementRegistDTO {
    private long userId;
    private long achievementId;

    public static UserAchievement toDomain(UserAchievementRegistDTO userAchievementInfo) {
        return new UserAchievement(
                userAchievementInfo.getAchievementId(),
                userAchievementInfo.getUserId()
        );
    }
}
