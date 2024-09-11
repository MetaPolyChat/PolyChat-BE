package com.polychat.polychatbe.userAchievement.query.repository;

import com.polychat.polychatbe.userAchievement.command.domain.aggregate.UserAchievement;
import com.polychat.polychatbe.userAchievement.query.dto.OneUserAchievementInfoDTO;
import com.polychat.polychatbe.userAchievement.query.dto.UserAchievementResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAchievementSearchRepository {
    UserAchievementResponseDTO findUserAchievementById(Long id);
    List<UserAchievementResponseDTO> findAllUserAchievements();
    OneUserAchievementInfoDTO findOneUserAchievements(Long userNo);
}
