package com.polychat.polychatbe.announcement.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementDeleteRequest {
    private Long userNo;
}
