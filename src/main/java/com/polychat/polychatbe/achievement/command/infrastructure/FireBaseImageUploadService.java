package com.polychat.polychatbe.achievement.command.infrastructure;

import com.polychat.polychatbe.achievement.command.domain.service.ImageUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

// 아직 미구현

@Service
public class FireBaseImageUploadService implements ImageUploadService {
    @Override
    public String getFileUrl(String fileName) {
        return "";
    }

    @Override
    public String uploadImage(String fileName, MultipartFile file) {
        return "";
    }

    @Override
    public String deleteImage(String fileName) {
        return "";
    }
}
