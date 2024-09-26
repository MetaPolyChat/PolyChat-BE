package com.polychat.polychatbe.friendBoard.dto;

import com.polychat.polychatbe.friendBoard.entity.friendBoard;

import java.time.LocalDateTime;

public class friendBoardDTO {
    String title;
    String context;
    String nickname;
    String usernumber;
    String startAt;
    String endAt;

    public friendBoardDTO(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public friendBoard toEntity(){
        friendBoard fb = new friendBoard();
        fb.setTitle(this.title);
        fb.setContext(this.context);
        fb.setNickname(this.nickname);
        fb.setUsernumber(Integer.parseInt(this.usernumber));
        fb.setStartAt(LocalDateTime.parse(this.startAt));
        fb.setEndAt(LocalDateTime.parse(this.endAt));
        return fb;
    }
}
