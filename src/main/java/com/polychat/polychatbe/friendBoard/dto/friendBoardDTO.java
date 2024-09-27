package com.polychat.polychatbe.friendBoard.dto;

import com.polychat.polychatbe.friendBoard.entity.friendBoard;
import lombok.Getter;

import java.time.LocalDateTime;

public class friendBoardDTO {

    private String writer;
    private String board_title;
    private String board_content;
    private String interest_id;
    public friendBoardDTO(){}

    public friendBoardDTO(String writer, String board_title, String board_content, String interest_id) {
        this.writer = writer;
        this.board_title = board_title;
        this.board_content = board_content;
        this.interest_id = interest_id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    public String getBoard_content() {
        return board_content;
    }

    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }

    public String getInterest_id() {
        return interest_id;
    }

    public void setInterest_id(String interest_id) {
        this.interest_id = interest_id;
    }

    @Override
    public String toString() {
        return "friendBoardDTO{" +
                "writer='" + writer + '\'' +
                ", board_title='" + board_title + '\'' +
                ", board_content='" + board_content + '\'' +
                ", interest_id='" + interest_id + '\'' +
                '}';
    }

    public friendBoard toEntity(){
        friendBoard fb = new friendBoard();
        fb.setBoard_title(this.board_title);
        fb.setBoard_context(this.board_content);
        fb.setWriter(Long.parseLong(this.writer));
        fb.setInterest_Id(Long.parseLong(this.interest_id));

        return fb;
    }
}
