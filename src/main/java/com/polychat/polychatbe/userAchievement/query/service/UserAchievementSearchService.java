package com.polychat.polychatbe.userAchievement.query.service;

import com.polychat.polychatbe.userAchievement.query.dto.OneUserAchievementInfoDTO;
import com.polychat.polychatbe.userAchievement.query.dto.UserAchievementResponseDTO;
import com.polychat.polychatbe.userAchievement.query.repository.UserAchievementSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAchievementSearchService {

    private UserAchievementSearchRepository userAchievementSearchRepository;

    public UserAchievementSearchService(UserAchievementSearchRepository userAchievementSearchRepository) {
        this.userAchievementSearchRepository = userAchievementSearchRepository;
    }

    public List<UserAchievementResponseDTO> findAllUserAchievements(){
        return userAchievementSearchRepository.findAllUserAchievements();
    }

    public UserAchievementResponseDTO findUserAchievementById(long id){
        return userAchievementSearchRepository.findUserAchievementById(id);
    }

    public OneUserAchievementInfoDTO findOneUserAchievements(long userNo){
        return userAchievementSearchRepository.findOneUserAchievements(userNo);
    }


}
