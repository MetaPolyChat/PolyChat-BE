package com.polychat.polychatbe.inerest.command.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="Interest")
@Table(name="TBL_INTEREST")
public class Interest {

    @Id
    @Column(name="INTEREST_ID")
    private long interestId;

    @Column(name="INTEREST_NAME")
    private String interestName;
}
