package com.polychat.polychatbe.announcement.command.application.dto;

import com.polychat.polychatbe.announcement.command.domain.aggregate.Announcement;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnnounceAddRequest {
    @NotBlank(message = "부적절한 접근입니다.")
    private long uploaderId;

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    @Size(min = 10, message = "내용은 10글자 이상 입력해야 합니다.")
    private String content;

    @Past
    private LocalDateTime uploadTime;

    private Long announcementId;

    public static Announcement announcementFromDto(AnnounceAddRequest announceAddRequest){

        if(announceAddRequest.getUploadTime() ==null ){
            announceAddRequest.setUploadTime(LocalDateTime.now());
        }

        return new Announcement(
                announceAddRequest.getUploaderId(),
                announceAddRequest.getTitle(),
                announceAddRequest.getContent(),
                announceAddRequest.getUploadTime(),
                LocalDateTime.now()
        );
    }
}


