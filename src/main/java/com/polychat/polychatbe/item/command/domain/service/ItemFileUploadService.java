package com.polychat.polychatbe.item.command.domain.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ItemFileUploadService {
    String getFileUrl(String filePath);
    String uploadImage(MultipartFile file);
    void deleteImage(String filePath);

}
