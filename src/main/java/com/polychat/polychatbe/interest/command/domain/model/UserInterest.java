package com.polychat.polychatbe.interest.command.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_USER_INTEREST")
public class UserInterest {

    @Id
    @Column(name = "REF_INTEREST_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refInterestNo;

    @Column(name = "USER_NO", nullable = false)
    private Long userNo;

    @Column(name = "INTEREST_NO", nullable = false)
    private Long interestNo;

    public UserInterest() {}

    public UserInterest(Long userNo, Long interestNo) {
        this.userNo = userNo;
        this.interestNo = interestNo;
    }

    public UserInterest(Long refInterestNo, Long userNo, Long interestNo) {
        this.refInterestNo = refInterestNo;
        this.userNo = userNo;
        this.interestNo = interestNo;
    }

    public Long getRefInterestNo() {
        return refInterestNo;
    }

    public Long getUserNo() {
        return userNo;
    }

    public Long getInterestNo() {
        return interestNo;
    }

    @Override
    public String toString() {
        return "UserInterest{" +
                "refInterestNo=" + refInterestNo +
                ", userNo=" + userNo +
                ", interestNo=" + interestNo +
                '}';
    }
}
