package com.polychat.polychatbe.inerest.command.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_INEREST")
public class Interest {

    @Id
    @Column(name="INEREST_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestNo;


    @Column(name="INTEREST_NAME")
    private String interestName;

    public Interest() {}

    public Interest(String interestName) {}

    public Long getInterestNo() {
        return interestNo;
    }

    public String getInterestName() {
        return interestName;
    }

    @Override
    public String toString() {
        return "Interest{" +
                "interestId=" + interestNo +
                ", interestName='" + interestName + '\'' +
                '}';
    }
}
