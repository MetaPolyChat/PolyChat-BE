//package com.polychat.polychatbe.common.fileStorage;
//
//
//import com.google.cloud.storage.Blob;
//import com.google.cloud.storage.Bucket;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URLEncoder;
//import java.nio.charset.StandardCharsets;
//import java.text.Normalizer;
//
//@Slf4j
//public class FireBaseFileStorageService implements FileStorageService {
//
//    //    private String firebaseBucket;
//    private Bucket bucket;
//
//    public FireBaseFileStorageService(Bucket bucket) {
//        this.bucket = bucket;
//    }
//
//    public String originalFileName(MultipartFile file){
//        return
//                Normalizer.normalize(file.getOriginalFilename(), Normalizer.Form.NFC);
//    }
//
//    public String getFileUrl(String filePath) {
//        try {
//            Blob blob = bucket.get(filePath);
//            if (blob != null) {
//                String FileUrl = String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media",
//                        bucket.getName(), URLEncoder.encode(filePath, StandardCharsets.UTF_8.toString()));
//                return FileUrl;
//
//            }
//        } catch (Exception e) {
//            log.warn("try file path:{}", filePath);
//            throw new IllegalArgumentException("파일을 읽어오는 데 실패했습니다.");
//        }
//        return null;
//    }
//
//
//    @Override
//    public String uploadFile(String filePath, MultipartFile file) throws IOException {
//        try {
//            InputStream content = new ByteArrayInputStream(file.getBytes());
//            bucket.create(filePath, content, file.getContentType());
//            return getFileUrl(filePath);
//        } catch (IOException e) {
//            log.warn("파일 업로드 중 오류 발생, 파일 이름 : {}", filePath);
//            throw new IOException("파일 업로드 중 오류가 발생했습니다.");
//        }
//    }
//
//    @Override
//    public void deleteFile(String filePath) throws IOException{
//        bucket.get(filePath).delete();
//    }
//}
