package com.polychat.polychatbe.matchingHistory.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMatchingHistoryDTO {
    private Long userNumFoo;
    private Long userNumBar;
    private Boolean isAiMatch;
}
