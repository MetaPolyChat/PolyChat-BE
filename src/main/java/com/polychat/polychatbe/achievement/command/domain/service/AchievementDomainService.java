package com.polychat.polychatbe.achievement.command.domain.service;

import com.polychat.polychatbe.achievement.command.domain.aggregate.Achievement;
import com.polychat.polychatbe.achievement.command.domain.repository.AchievementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
public class AchievementDomainService {

    private AchievementRepository achievementRepository;
    private ImageUploadService imageUploadService;

    public AchievementDomainService(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    @Transactional
    public void uploadImage(Achievement achievement, String fileName, MultipartFile file) {
        try{
            String uploadedUrl = imageUploadService.uploadImage(fileName, file);
            achievement.setAchievementIconUrl(uploadedUrl);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }


}
