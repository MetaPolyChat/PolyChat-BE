package com.polychat.polychatbe.announcement.command.application.dto;

import com.polychat.polychatbe.announcement.command.domain.aggregate.Announcement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnnounceAddRequest {
    private long uploaderId;
    private String title;
    private String content;
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


