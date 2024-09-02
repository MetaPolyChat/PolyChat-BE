package com.polychat.polychatbe.achievement.command.domain.repository;

import com.polychat.polychatbe.achievement.command.domain.aggregate.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}
