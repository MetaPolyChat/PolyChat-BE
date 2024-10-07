package com.polychat.polychatbe.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import com.polychat.polychatbe.achievement.command.domain.service.ImageUploadService;
import com.polychat.polychatbe.achievement.command.infrastructure.FireBaseImageUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FileUploadConfig {

    @Value("${app.firebase-configuration-file}")
    private String firebaseKeyPath;

    @Value("${app.firebase-bucket}")
    private String firebaseBucketName;

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        if(FirebaseApp.getApps().isEmpty()){
            Resource resource = new ClassPathResource(firebaseKeyPath);

            //System.out.println(firebaseKeyPath);
            FileInputStream fis = new FileInputStream(resource.getFile());

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(fis))
                    .setStorageBucket(firebaseBucketName)
                    .build();

            return FirebaseApp.initializeApp(options);
        }

        return FirebaseApp.getInstance();
    }

    @Bean
    public Bucket bucket() throws IOException{
        return StorageClient.getInstance(firebaseApp()).bucket();
    }

    @Bean
    public ImageUploadService FirebaseImageUploadService() throws IOException {
        return new FireBaseImageUploadService(bucket());
    }

}
