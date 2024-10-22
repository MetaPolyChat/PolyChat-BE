package com.polychat.polychatbe.announcement.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AnnouncementDeleteRequest {
    private long userNo;
}
