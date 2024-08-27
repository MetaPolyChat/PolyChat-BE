package com.polychat.polychatbe.announcement.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.StringTokenizer;

@Getter
@Entity
@Table(name = "TBL_ANNOUNCEMENT")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long announcementId;

    private long uploaderId;
    private String announcementTitle;
    private String announcementContent;
    private LocalDateTime uploadTime;
    private LocalDateTime lastUpdatedTime;

    protected Announcement () {}

    public Announcement(long uploaderId, String announcementTitle, String announcementContent,
                        LocalDateTime uploadTime, LocalDateTime lastUpdatedTime) {
        this.uploaderId = uploaderId;
        this.announcementTitle = announcementTitle;
        this.announcementContent = announcementContent;
        this.uploadTime = uploadTime;
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public void updateAnnouncement(String announcementTitle, String announcementContent, LocalDateTime lastUpdatedTime) {
        this.announcementTitle = announcementTitle;
        this.announcementContent = announcementContent;
        this.lastUpdatedTime = lastUpdatedTime;
    }
}
