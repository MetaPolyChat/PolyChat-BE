package com.polychat.polychatbe.announcement.command.domain.aggregate;

import com.polychat.polychatbe.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "TBL_ANNOUNCEMENT")
public class Announcement extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long announcementId;

    private long uploaderId;
    private String announcementTitle;
    private String announcementContent;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedDate;

    protected Announcement () {}

    public Announcement(long uploaderId, String announcementTitle, String announcementContent) {
        this.uploaderId = uploaderId;
        this.announcementTitle = announcementTitle;
        this.announcementContent = announcementContent;
    }

    public Announcement(long uploaderId, String announcementTitle, String announcementContent,
                        LocalDateTime createdAt, LocalDateTime updatedDate) {
        this.uploaderId = uploaderId;
        this.announcementTitle = announcementTitle;
        this.announcementContent = announcementContent;
//        this.createdAt = createdAt;
//        this.updatedDate = updatedDate;
    }

    public void updateAnnouncement(String announcementTitle, String announcementContent, LocalDateTime lastUpdatedTime) {
        this.announcementTitle = announcementTitle;
        this.announcementContent = announcementContent;
        //this.updatedDate = lastUpdatedTime;
    }
}
