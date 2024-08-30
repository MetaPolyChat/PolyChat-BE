package com.polychat.polychatbe.matchingHistory.command.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_matching_history")
public class MatchingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int matchingId;

    @Column
    private long userNumFirst;

    @Column
    private long userNumSecond;

    @Column
    private LocalDateTime matchTime;

    @Column
    private boolean isAiMatch;

}
