package com.polychat.polychatbe.interest.command.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_USER_INTEREST")
public class UserInterest {

    @Id
    @Column(name = "REF_INTEREST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refInterestId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "INTEREST_ID", nullable = false)
    private Long interestId;

    public UserInterest() {}

    public UserInterest(Long userId, Long interestId) {
        this.userId = userId;
        this.interestId = interestId;
    }

    public Long getRefInterestId() {
        return refInterestId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getInterestId() {
        return interestId;
    }

    @Override
    public String toString() {
        return "UserInterest{" +
                "refInterestId=" + refInterestId +
                ", userId=" + userId +
                ", interestId=" + interestId +
                '}';
    }
}
