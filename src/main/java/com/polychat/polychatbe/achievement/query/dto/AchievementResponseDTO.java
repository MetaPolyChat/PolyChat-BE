package com.polychat.polychatbe.achievement.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AchievementResponseDTO {
    private int achievementId;

    private String achievementName;
    private String achievementDescription;
    private String achievementCondition;
    private String achievementIcon;
    private String isActive;
}
