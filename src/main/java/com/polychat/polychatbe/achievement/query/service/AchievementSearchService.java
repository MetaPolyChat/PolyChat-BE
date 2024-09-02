package com.polychat.polychatbe.achievement.query.service;

import com.polychat.polychatbe.achievement.query.dto.AchievementResponseDTO;
import com.polychat.polychatbe.achievement.query.repository.AchievementSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public AchievementResponseDTO findAchievementById(long id) {
        return achievementSearchRepository.findAchievementById(id);
    }
}
