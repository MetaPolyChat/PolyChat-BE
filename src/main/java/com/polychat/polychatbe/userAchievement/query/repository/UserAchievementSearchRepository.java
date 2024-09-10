package com.polychat.polychatbe.userAchievement.query.repository;

import com.polychat.polychatbe.userAchievement.command.domain.aggregate.UserAchievement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAchievementSearchRepository {
    UserAchievement findUserAchievementById(Long id);
    List<UserAchievement> findAllUserAchievements();
    List<UserAchievement> findOneUserAchievements(Long userId);
}
