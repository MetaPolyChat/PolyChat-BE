package com.polychat.polychatbe;

import com.polychat.polychatbe.achievement.command.domain.service.ImageUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.Normalizer;

@RestController
@RequestMapping("test")
@Slf4j
public class uploadTestController {

    private ImageUploadService imageUploadService;

    public uploadTestController(ImageUploadService imageUploadService) {
        this.imageUploadService = imageUploadService;
    }

    @PostMapping("upload")
    public String fileUploadTest(@ModelAttribute MultipartFile file) throws IOException {
        String fileName=
                Normalizer.normalize(file.getOriginalFilename(), Normalizer.Form.NFC);
        log.info("파일 이름 : {}", fileName);
        return imageUploadService.uploadImage("test/"+fileName, file);
    }
}