package com.polychat.polychatbe.common.fileStorage;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {

    String uploadFile(String filePath, MultipartFile file) throws IOException;
    void deleteFile(String filePath) throws IOException;
}
