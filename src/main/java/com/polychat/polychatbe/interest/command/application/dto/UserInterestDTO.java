package com.polychat.polychatbe.interest.command.application.dto;

import java.util.List;

public class UserInterestDTO {

    private Long refInterestId;
    private Long userId;
    private Long interestId;

    public UserInterestDTO() {}

    public UserInterestDTO(Long refInterestId, Long userId, Long interestId) {
        this.refInterestId = refInterestId;
        this.userId = userId;
        this.interestId = interestId;
    }

    public Long getrefInterestId() {
        return refInterestId;
    }

    public void setrefInterestId(Long refInterestId) {
        this.refInterestId = refInterestId;
    }

    public Long getuserId() {
        return userId;
    }

    public void setuserId(Long userId) {
        this.userId = userId;
    }

    public Long getinterestId() {
        return interestId;
    }

    public void setinterestId(Long interestId) {
        this.interestId = interestId;
    }

    @Override
    public String toString() {
        return "UserInterestDTO{" +
                "refInterestId=" + refInterestId +
                ", userId=" + userId +
                ", interestId=" + interestId +
                '}';
    }

    /**
     * @param interests
     */
    public record newUserInterestDTO(Long userId, List<String> interests) {}

    public record updatedUserInterestDTO(Long userId, List<String> interests) {}
}
