package com.polychat.polychatbe.userAchievement.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAchievementModifyDTO {
    private long userNo;
    private long beforeAchievementId;
    private long afterAchievementId;
}
