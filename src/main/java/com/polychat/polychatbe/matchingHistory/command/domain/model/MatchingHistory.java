package com.polychat.polychatbe.matchingHistory.command.domain.model;

import com.polychat.polychatbe.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@ToString
@Builder
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name = "tbl_matching_history")
public class MatchingHistory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long matchingId;

    @Column
    private Long userNumFoo;

    @Column
    private Long userNumBar;

    @Column
    private Boolean isAiMatch;


}
