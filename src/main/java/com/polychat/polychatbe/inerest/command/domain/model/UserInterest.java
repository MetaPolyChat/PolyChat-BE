package com.polychat.polychatbe.inerest.command.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserInterest {

    @Column(nullable = false)
    private long ref_interest_id;


}
