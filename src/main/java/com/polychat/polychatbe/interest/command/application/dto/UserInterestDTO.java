package com.polychat.polychatbe.interest.command.application.dto;

public class UserInterestDTO {

    private Long refInterestNo;
    private Long userNo;
    private Long interestNo;

    public UserInterestDTO() {}

    public UserInterestDTO(Long refInterestNo, Long userNo, Long interestNo) {
        this.refInterestNo = refInterestNo;
        this.userNo = userNo;
        this.interestNo = interestNo;
    }

    public Long getRefInterestNo() {
        return refInterestNo;
    }

    public void setRefInterestNo(Long refInterestNo) {
        this.refInterestNo = refInterestNo;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public Long getInterestNo() {
        return interestNo;
    }

    public void setInterestNo(Long interestNo) {
        this.interestNo = interestNo;
    }

    @Override
    public String toString() {
        return "UserInterestDTO{" +
                "refInterestNo=" + refInterestNo +
                ", userNo=" + userNo +
                ", interestNo=" + interestNo +
                '}';
    }
}
