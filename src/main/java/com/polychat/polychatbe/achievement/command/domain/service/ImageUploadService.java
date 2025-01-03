package com.polychat.polychatbe.achievement.command.domain.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageUploadService {

    String uploadImage(String filePath, MultipartFile file) throws IOException;
    void deleteImage(String filePath) throws IOException;

}
