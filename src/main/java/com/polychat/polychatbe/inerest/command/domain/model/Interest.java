package com.polychat.polychatbe.inerest.command.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_INEREST")
public class Interest {

    @Id
    @Column(name="INEREST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestId;


    @Column(name="INTEREST_NAME")
    private String interestName;

    public Interest() {}

    public Interest(String interestName) {}

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
