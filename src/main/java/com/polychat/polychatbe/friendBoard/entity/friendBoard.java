package com.polychat.polychatbe.friendBoard.entity;

import com.polychat.polychatbe.common.BaseTimeEntity;
import com.polychat.polychatbe.common.PolyTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_friend_board")
public class friendBoard extends BaseTimeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BOARD_TITLE", nullable = false)
    private String title;

    @Column(name = "BOARD_TEXT", nullable = false)
    private String bodyText;

//    @Column(name = "POST_DATA", nullable = false)
//    private LocalDateTime date;

    @Column(name = "USER_ID", nullable = false)
    private String userId;

    public friendBoard() {}

    // 필요하다면 생성자 추가 가능


    @Builder
    public friendBoard(String title, String bodyText, String userId) {
        this.title = title;
        this.bodyText = bodyText;
        this.userId = userId;
    }
}
