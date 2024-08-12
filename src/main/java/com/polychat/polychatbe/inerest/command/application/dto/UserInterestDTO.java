package com.polychat.polychatbe.inerest.command.application.dto;

import java.util.List;

public class UserInterestDTO {

    private Long userId;

    private List<String> interests;

    public UserInterestDTO() {}

    public UserInterestDTO(Long userId, List<String> interests) {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "UserInterestDTO{" +
                "userId=" + userId +
                ", interests=" + interests +
                '}';
    }
}
