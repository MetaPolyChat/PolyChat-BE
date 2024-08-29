package com.polychat.polychatbe.achievement.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name="TBL_ACHIEVEMENT")
@Getter
@ToString
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int achievementId;

    private String achievementName;
    private String achievementDescription;
    private String achievementCondition;
    private String achievementIconUrl;
    
    // 비활성화시 목록에 보이지 않음
    private String isActive;

    protected Achievement() {}

    public Achievement(String achievementName, String achievementDescription, String achievementCondition) {
        this.achievementName = achievementName;
        this.achievementDescription = achievementDescription;
        this.achievementCondition = achievementCondition;
        this.isActive = "Y";
    }

    public Achievement(String achievementName, String achievementDescription, String achievementCondition, String achievementIconUrl) {
        this(achievementName, achievementDescription, achievementCondition);
        this.achievementIconUrl = achievementIconUrl;
    }

    public void setAchievementIconUrl(String achievementIconUrl) {
        this.achievementIconUrl = achievementIconUrl;
    }

    public void activeAchievement() {
        this.isActive = "Y";
    }

    public void deActiveAchievement() {
        this.isActive = "N";
    }
}
