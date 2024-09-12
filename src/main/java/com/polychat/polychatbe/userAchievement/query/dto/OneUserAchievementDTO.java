package com.polychat.polychatbe.userAchievement.query.dto;

import com.polychat.polychatbe.achievement.query.dto.AchievementResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OneUserAchievementDTO {
    private long userNo;
    private List<AchievementResponseDTO> achievementList;

}

