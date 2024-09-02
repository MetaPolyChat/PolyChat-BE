package com.polychat.polychatbe.matchingHistory.command.application.dto;

import com.polychat.polychatbe.matchingHistory.command.domain.model.MatchingHistory;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class MatchingHistoryDTO {

    @Getter
    @Setter
    private Long userNumFoo;

    @Getter
    @Setter
    private Long userNumBar;

    @Getter
    @Setter
    private LocalDateTime matchTime;

    private boolean isAiMatch;


    public MatchingHistoryDTO() {
    }

    public MatchingHistoryDTO(Long userNumFoo, Long userNumBar, LocalDateTime matchTime, boolean isAiMatch) {
        this.userNumFoo = userNumFoo;
        this.userNumBar = userNumBar;
        this.matchTime = matchTime;
        this.isAiMatch = isAiMatch;
    }

    public MatchingHistoryDTO(MatchingHistory matchingHistory) {
        this(
                matchingHistory.getUserNumFoo(),
                matchingHistory.getUserNumBar(),
                matchingHistory.getMatchTime(),
                matchingHistory.isAiMatch()
        );
    }


    public boolean isAiMatch() {
        return isAiMatch;
    }

    public void setAiMatch(boolean aiMatch) {
        isAiMatch = aiMatch;
    }

    @Override
    public String toString() {
        return "MatchingHistoryDTO{" +
                "userNumFoo=" + userNumFoo +
                ", userNumBar=" + userNumBar +
                ", matchTime=" + matchTime +
                ", isAiMatch=" + isAiMatch +
                '}';
    }
}
