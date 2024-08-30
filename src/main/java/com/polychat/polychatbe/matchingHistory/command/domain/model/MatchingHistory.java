package com.polychat.polychatbe.matchingHistory.command.domain.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_matching_history")
public class MatchingHistory {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int matchingId;

    @Getter
    @Column
    private Long userNumFoo;

    @Getter
    @Column
    private Long userNumBar;

    @Getter
    @Column
    private LocalDateTime matchTime;

    @Column
    private boolean isAiMatch;

    public MatchingHistory() {
    }

    public MatchingHistory(Long userNumFoo, Long userNumBar, LocalDateTime matchTime, boolean isAiMatch) {
        this.userNumFoo = userNumFoo;
        this.userNumBar = userNumBar;
        this.matchTime = matchTime;
        this.isAiMatch = isAiMatch;
    }

    public boolean isAiMatch() {
        return isAiMatch;
    }

    @Override
    public String toString() {
        return "MatchingHistory{" +
                "userNumFirst=" + userNumFoo +
                ", userNumSecond=" + userNumBar +
                ", matchTime=" + matchTime +
                ", isAiMatch=" + isAiMatch +
                '}';
    }
}
