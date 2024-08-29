package com.polychat.polychatbe.achievement.command.application.service;

import com.polychat.polychatbe.achievement.command.application.dto.AchievementRequest;
import com.polychat.polychatbe.achievement.command.domain.aggregate.Achievement;
import com.polychat.polychatbe.achievement.command.domain.repository.AchievementRepository;
import com.polychat.polychatbe.achievement.command.domain.service.ImageUploadService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchievementService {

    private ImageUploadService imageUploadService;
    private AchievementRepository achievementRepository;

    public AchievementService(ImageUploadService imageUploadService, AchievementRepository achievementRepository) {
        this.imageUploadService = imageUploadService;
        this.achievementRepository = achievementRepository;
    }

    @Transactional
    public void addAchievement(AchievementRequest achievementRequest){

        Achievement achievement = AchievementRequest.achievementFromDTO(achievementRequest);

        if (achievementRequest.getAchievementImage() !=null) {
            String uploadUrl = imageUploadService.uploadImage(
                    achievementRequest.getAchievementImage().getOriginalFilename(),
                    achievementRequest.getAchievementImage());
            achievement.setAchievementIconUrl(uploadUrl);
        }

        achievementRepository.save(achievement);
    }

    @Transactional
    public void deleteAchievement(long achievementId){
        Achievement achievement = achievementRepository.findById(achievementId).orElseThrow(
                () -> new NoSuchElementException("해당 업적을 찾을 수 없습니다.")
        );

        // 테이블에서 삭제하는 대신 비활성화 상태로만 변경
        achievement.deActiveAchievement();
    }


}
