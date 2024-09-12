package com.polychat.polychatbe.userAchievement.command.application.service;

import com.polychat.polychatbe.userAchievement.command.application.dto.UserAchievementModifyDTO;
import com.polychat.polychatbe.userAchievement.command.application.dto.UserAchievementRegistDTO;
import com.polychat.polychatbe.userAchievement.command.domain.aggregate.UserAchievement;
import com.polychat.polychatbe.userAchievement.command.domain.repository.UserAchievementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class UserAchievementService {

    private UserAchievementRepository userAchievementRepository;

    public UserAchievementService(UserAchievementRepository userAchievementRepository) {
        this.userAchievementRepository = userAchievementRepository;
    }


    @Transactional
    public void addUserAchievement(UserAchievementRegistDTO userAchievementInfo) {
        UserAchievement userAchievement = UserAchievementRegistDTO.toDomain(userAchievementInfo);
        userAchievementRepository.save(userAchievement);
    }

    @Transactional
    public void modifyOneUserAchievement(UserAchievementModifyDTO newUserAchievement) {
        UserAchievement userAchievement = userAchievementRepository.findByUserNoAndAchievementId(
                newUserAchievement.getUserNo(), newUserAchievement.getBeforeAchievementId());

        userAchievement.setAchievementId(newUserAchievement.getAfterAchievementId());
    }

    @Transactional
    public void deleteUserAchievement(long userAchievementId) {
        UserAchievement userAchievement = userAchievementRepository.findById(userAchievementId)
                .orElseThrow(NoSuchElementException::new);

        userAchievementRepository.delete(userAchievement);

    }


}
