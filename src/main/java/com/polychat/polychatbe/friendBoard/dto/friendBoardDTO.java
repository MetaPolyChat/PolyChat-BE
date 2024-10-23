package com.polychat.polychatbe.friendBoard.dto;

import com.polychat.polychatbe.common.PolyTime;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class friendBoardDTO {


    public String title;
    public String bodyText;
    public String date;
    public String userId;

    public friendBoardDTO(){}

    public friendBoardDTO(String title, String bodyText, String date, String userId ) {
        this.title = title;
        this.bodyText = bodyText;
        this.date = date;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
