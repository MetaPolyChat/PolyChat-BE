package com.polychat.polychatbe.item.command.infrastructure;

import com.polychat.polychatbe.item.command.domain.service.ItemFileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

// 미구현
@Service
public class FireBaseUploadService implements ItemFileUploadService {
    @Override
    public String getFileUrl(String filePath) {
        return "";
    }

    @Override
    public String uploadImage(MultipartFile file){
        return "";
    }

    @Override
    public void deleteImage(String filePath) {

    }
}
