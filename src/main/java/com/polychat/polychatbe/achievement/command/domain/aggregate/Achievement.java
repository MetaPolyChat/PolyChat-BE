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
    private Long achievementId;

    private String achievementName;
    private String achievementDescription;
    private String achievementCondition;
    private String achievementIconUrl;
    
    // 비활성화시 목록에 보이지 않음
    private String achievementActive;

    protected Achievement() {}

    public Achievement(String achievementName, String achievementDescription, String achievementCondition) {
        this.achievementName = achievementName;
        this.achievementDescription = achievementDescription;
        this.achievementCondition = achievementCondition;
        this.achievementActive = "Y";
    }

    public Achievement(String achievementName, String achievementDescription, String achievementCondition, String achievementIconUrl) {
        this(achievementName, achievementDescription, achievementCondition);
        this.achievementIconUrl = achievementIconUrl;
    }

    public Achievement(Long achievementId, String achievementName, String achievementDescription, String achievementCondition) {
        this.achievementId = achievementId;
        this.achievementName = achievementName;
        this.achievementDescription = achievementDescription;
        this.achievementCondition = achievementCondition;
    }

    public void updateAchievement(Achievement newAchievement){
        this.achievementName =  newAchievement.achievementName!=null?
                newAchievement.getAchievementName():this.achievementName;
        this.achievementDescription =  newAchievement.achievementDescription!=null?
                newAchievement.getAchievementDescription():this.achievementDescription;
        this.achievementCondition = newAchievement.achievementCondition!=null?
                newAchievement.getAchievementCondition():this.achievementCondition;
        this.achievementActive = newAchievement.achievementActive!=null?
                newAchievement.getAchievementActive():this.achievementActive;
        this.achievementIconUrl = newAchievement.achievementIconUrl!=null?
                newAchievement.getAchievementIconUrl():this.achievementIconUrl;

    }


    public void setAchievementIconUrl(String achievementIconUrl) {
        this.achievementIconUrl = achievementIconUrl;
    }

    public void activeAchievement() {
        this.achievementActive = "Y";
    }

    public void deActiveAchievement() {
        this.achievementActive = "N";
    }
}
