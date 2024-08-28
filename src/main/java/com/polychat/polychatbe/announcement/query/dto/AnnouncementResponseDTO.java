package com.polychat.polychatbe.announcement.query.dto;

import com.polychat.polychatbe.announcement.command.domain.aggregate.Announcement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementResponseDTO {

    private long announcementId;
    private String announcementTitle;
    private String announcementContent;
    private LocalDateTime uploadTime;
    private LocalDateTime lastUpdatedTime;
    private long uploaderNo;
    private String uploaderName;


}
