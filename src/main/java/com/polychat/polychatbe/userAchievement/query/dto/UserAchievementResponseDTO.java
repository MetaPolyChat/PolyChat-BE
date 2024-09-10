package com.polychat.polychatbe.userAchievement.query.dto;

import com.polychat.polychatbe.achievement.query.dto.AchievementResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAchievementResponseDTO {
    private long userAchievementId;
    private long userNo;
    private AchievementResponseDTO achievement;
}