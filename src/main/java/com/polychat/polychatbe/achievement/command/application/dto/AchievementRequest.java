package com.polychat.polychatbe.achievement.command.application.dto;

import com.polychat.polychatbe.achievement.command.domain.aggregate.Achievement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AchievementRequest {

    private Long achievementId;
    private String achievementName;
    private String achievementDescription;
    private String achievementCondition;
    private MultipartFile achievementImage;

    public AchievementRequest(String achievementName, String achievementDescription, String achievementCondition, MultipartFile achievementImage) {
        this.achievementName = achievementName;
        this.achievementDescription = achievementDescription;
        this.achievementCondition = achievementCondition;
        this.achievementImage = achievementImage;
    }

    public static Achievement achievementFromDTO(AchievementRequest achievementRequest) {
        return new Achievement(
                achievementRequest.getAchievementName(),
                achievementRequest.getAchievementDescription(),
                achievementRequest.getAchievementCondition()
        );
    }

    public static Achievement achievementWithIdFromDTO(AchievementRequest achievementRequest) {
        return new Achievement(
                achievementRequest.getAchievementId(),
                achievementRequest.getAchievementName(),
                achievementRequest.getAchievementDescription(),
                achievementRequest.getAchievementCondition()
        );
    }


}
