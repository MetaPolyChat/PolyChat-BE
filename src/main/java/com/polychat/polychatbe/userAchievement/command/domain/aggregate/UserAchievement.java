package com.polychat.polychatbe.userAchievement.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name="TBL_USER_ACHIEVEMENT")
@Getter
@ToString
public class UserAchievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userAchievementId;

    private long achievementId;
    private long userNo;


    protected UserAchievement() {}

    public UserAchievement(long achievementId, long userNo) {
        this.achievementId = achievementId;
        this.userNo = userNo;
    }

    public void setAchievementId(long achievementId) {
        this.achievementId = achievementId;
    }
}
