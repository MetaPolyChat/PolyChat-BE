package com.polychat.polychatbe.achievement.command.application.dto;

import com.polychat.polychatbe.achievement.command.domain.aggregate.Achievement;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AchievementRequest {

    private Long achievementId;

    @NotBlank(message = "업적 이름을 입력해주세요.")
    private String achievementName;

    @NotBlank(message = "업적 설명을 입력해주세요.")
    @Size(min = 10, message = "업적 설명은 10글자 이상 입력해야 합니다.")
    private String achievementDescription;

    @NotBlank(message = "업적 달성 조건을 입력해주세요.")
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
