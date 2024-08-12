package com.polychat.polychatbe.inerest.command.domain.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Entity
@Table(name="TBL_USER_INTEREST")
public class UserInterest {

    @Id
    @Column(name = "REF_INTEREST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ref_interest_id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "INTEREST_ID")
    private Long interestId;

    public UserInterest() {}

    public UserInterest(Long userId, Long interestId) {
        this.userId = userId;
        this.interestId = interestId;
    }

    public Long getRef_interest_id() {
        return ref_interest_id;
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
                "ref_interest_id=" + ref_interest_id +
                ", userId=" + userId +
                ", interestId=" + interestId +
                '}';
    }
}
