package com.polychat.polychatbe.achievement.command.domain.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {

    String getFileUrl(String fileName);
    String uploadImage(String fileName, MultipartFile file);
    String deleteImage(String fileName);

}
