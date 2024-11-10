package com.polychat.polychatbe.achievement.command.infrastructure;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import com.polychat.polychatbe.achievement.command.domain.service.ImageUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
public class FireBaseImageUploadService implements ImageUploadService {

//    private String firebaseBucket;
    private Bucket bucket;

    public FireBaseImageUploadService(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public String getFileUrl(String filePath) {
        try {
            //Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
            Blob blob = bucket.get(filePath);
            if (blob != null) {
                String FileUrl = String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media",
                        bucket.getName(), URLEncoder.encode(filePath, StandardCharsets.UTF_8.toString()));
                return FileUrl;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String uploadImage(String filePath, MultipartFile file) throws IOException {
        try {
            InputStream content = new ByteArrayInputStream(file.getBytes());
            Blob blob = bucket.create(filePath, content, file.getContentType());
            return getFileUrl(filePath);
            //return blob.getMediaLink();
        } catch (IOException e) {
            log.warn("파일 업로드 중 오류 발생, 파일 이름 : {}", filePath);
            throw new IOException("파일 업로드 중 오류가 발생했습니다.");
        }
    }

    @Override
    public void deleteImage(String filePath) {
        bucket.get(filePath).delete();
    }
}
