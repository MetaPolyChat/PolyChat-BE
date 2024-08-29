package com.polychat.polychatbe.achievement.query.service;

import com.polychat.polychatbe.achievement.query.dto.AchievementResponseDTO;
import com.polychat.polychatbe.achievement.query.repository.AchievementSearchRepository;

import java.util.List;

public class AchievementSearchService {

    private AchievementSearchRepository achievementSearchRepository;

    public long countAchievement() {
        return achievementSearchRepository.countAchievement();
    }

    public AchievementSearchService(AchievementSearchRepository achievementSearchRepository) {
        this.achievementSearchRepository = achievementSearchRepository;
    }

    public List<AchievementResponseDTO> findAllAchievement() {
        return achievementSearchRepository.findAllAchievement();
    }

    public AchievementResponseDTO findAchievementById(int id) {
        return achievementSearchRepository.findAchievementById(id);
    }
}
