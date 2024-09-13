package com.polychat.polychatbe.interest.command.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_INTEREST")
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestNo;


    @Column(name="INTEREST_NAME", nullable = false)
    private String interestName;

    public Interest() {}

    public Interest(String interestName) {
        this.interestName = interestName;
    }

    public Interest(Long interestNo, String interestName) {
        this.interestNo = interestNo;
        this.interestName = interestName;
    }

    public Long getInterestNo() {
        return interestNo;
    }

    public String getInterestName() {
        return interestName;
    }

    public void updateInterest(Interest interest) {
        this.interestNo = interest.getInterestNo();
        this.interestName = interest.getInterestName();
    }

    @Override
    public String toString() {
        return "Interest{" +
                "interestId=" + interestNo +
                ", interestName='" + interestName + '\'' +
                '}';
    }
}
