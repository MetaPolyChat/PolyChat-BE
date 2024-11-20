package com.polychat.polychatbe.matchingHistory.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchingHistoryDTO {
    private Long matchingId;
    private Long userNumFoo;
    private Long userNumBar;
    private Boolean isAiMatch;
    private String createdAt;
}
