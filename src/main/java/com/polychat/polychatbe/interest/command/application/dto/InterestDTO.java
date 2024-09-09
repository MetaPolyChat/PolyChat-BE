package com.polychat.polychatbe.interest.command.application.dto;

public class InterestDTO {

    private Long interestNo;
    private String interestName;

    public InterestDTO() {}

    public InterestDTO(Long interestNo, String interestName) {
        this.interestNo = interestNo;
        this.interestName = interestName;
    }

    public Long getInterestNo() {
        return interestNo;
    }

    public void setInterestNo(Long interestNo) {
        this.interestNo = interestNo;
    }

    public String getInterestName() {
        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }

    @Override
    public String toString() {
        return "InterestDTO{" +
                "interestNo=" + interestNo +
                ", interestName='" + interestName + '\'' +
                '}';
    }
}