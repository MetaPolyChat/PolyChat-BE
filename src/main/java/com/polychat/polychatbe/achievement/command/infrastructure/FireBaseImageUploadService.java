package com.polychat.polychatbe.achievement.command.infrastructure;

import com.polychat.polychatbe.achievement.command.domain.service.ImageUploadService;
import com.polychat.polychatbe.common.fileStorage.FileStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
public class FireBaseImageUploadService implements ImageUploadService {

    private FileStorageService fileStorageService;

    public FireBaseImageUploadService(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @Override
    public String uploadImage(String filePath, MultipartFile file) throws IOException {
        return fileStorageService.uploadFile(filePath, file);
    }

    @Override
    public void deleteImage(String filePath) throws IOException {
        fileStorageService.deleteFile(filePath);
    }
}
