package com.polychat.polychatbe.interest.command.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_INTEREST")
public class Interest {

    @Id
    @Column(name="INTEREST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestId;


    @Column(name="INTEREST_NAME", nullable = false)
    private String interestName;

    public Interest() {}

    public Interest(String interestName) {
        this.interestName = interestName;
    }

    public Long getInterestId() {
        return interestId;
    }

    public String getInterestName() {
        return interestName;
    }

    @Override
    public String toString() {
        return "Interest{" +
                "interestId=" + interestId +
                ", interestName='" + interestName + '\'' +
                '}';
    }
}
