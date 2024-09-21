package com.polychat.polychatbe.interest.command.application.service;

import com.polychat.polychatbe.interest.command.domain.model.Interest;
import com.polychat.polychatbe.interest.command.domain.service.InterestService;
import org.springframework.stereotype.Service;

@Service
public class InterestAdminService {

    private InterestService interestService;

    public InterestAdminService(InterestService interestService) {
        this.interestService = interestService;
    }

    public Interest registInterest(String interestName){
        // success: Object, fail: null
        return interestService.registInterest(interestName);
    }

    public String removeInterest(String interestName){
        return interestService.removeInterest(interestName);
    }
}
