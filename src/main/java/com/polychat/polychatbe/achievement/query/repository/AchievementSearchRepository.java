
package com.polychat.polychatbe.achievement.query.repository;

import com.polychat.polychatbe.achievement.query.dto.AchievementResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AchievementSearchRepository {

    long countAchievement();
    AchievementResponseDTO findAchievementById(Long achievementId);
    List<AchievementResponseDTO> findAllAchievement();

}
