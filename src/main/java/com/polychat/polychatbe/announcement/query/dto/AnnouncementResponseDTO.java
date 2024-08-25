package com.polychat.polychatbe.announcement.query.dto;

import com.polychat.polychatbe.announcement.command.domain.aggregate.Announcement;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnnouncementResponseDTO {

    private long announcementId;
    private String announcementTitle;
    private String announcementContent;
    private LocalDateTime uploadTime;
    private LocalDateTime lastUpdatedTime;

    public AnnouncementResponseDTO() {
    }

    public AnnouncementResponseDTO(long announcementId, String announcementTitle, String announcementContent, LocalDateTime uploadTime, LocalDateTime lastUpdatedTime) {
        this.announcementId = announcementId;
        this.announcementTitle = announcementTitle;
        this.announcementContent = announcementContent;
        this.uploadTime = uploadTime;
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public AnnouncementResponseDTO(Announcement announcement){
        this(announcement.getAnnouncementId(),
                announcement.getAnnouncementTitle(),
                announcement.getAnnouncementContent(),
                announcement.getUploadTime(),
                announcement.getLastUpdatedTime());
    }
}
