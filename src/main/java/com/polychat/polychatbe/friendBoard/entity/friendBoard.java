package com.polychat.polychatbe.friendBoard.entity;

import com.polychat.polychatbe.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "tbl_friend_board")
public class friendBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="writer")
    private Long writer;

    @Column(name ="board_title")
    private String board_title;

    @Column(name ="board_context")
    private String board_context;

    @Column(name ="interest_id")
    private Long interest_Id;

    public friendBoard() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWriter() {
        return writer;
    }

    public void setWriter(Long writer) {
        this.writer = writer;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    public String getBoard_context() {
        return board_context;
    }

    public void setBoard_context(String board_context) {
        this.board_context = board_context;
    }

    public Long getInterest_Id() {
        return interest_Id;
    }

    public void setInterest_Id(Long interest_Id) {
        this.interest_Id = interest_Id;
    }
}
