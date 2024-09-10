package com.polychat.polychatbe.userAchievement.command.domain.repository;


import com.polychat.polychatbe.userAchievement.command.domain.aggregate.UserAchievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAchievementRepository extends JpaRepository<UserAchievement, Long> {
    UserAchievement findByUserIdAndAchievementId(Long userId, Long achievementId);
}
