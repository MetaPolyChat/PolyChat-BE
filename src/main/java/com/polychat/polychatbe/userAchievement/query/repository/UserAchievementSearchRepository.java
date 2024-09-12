package com.polychat.polychatbe.userAchievement.query.repository;

import com.polychat.polychatbe.userAchievement.query.dto.OneUserAchievementDTO;
import com.polychat.polychatbe.userAchievement.query.dto.UserAchievementResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAchievementSearchRepository {
    UserAchievementResponseDTO findUserAchievementById(Long id);
    List<UserAchievementResponseDTO> findAllUserAchievements();
    OneUserAchievementDTO findOneUserAchievements(Long userNo);
}
