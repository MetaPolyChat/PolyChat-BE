package com.polychat.polychatbe.interest.command.application.service;

import com.polychat.polychatbe.interest.command.application.dto.SignUpUserInterestDTO;
import com.polychat.polychatbe.interest.command.application.dto.UserInterestDTO;
import com.polychat.polychatbe.interest.command.domain.service.UserInterestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestUserService {

    private UserInterestService userInterestService;

    public InterestUserService(UserInterestService userInterestService) {
        this.userInterestService = userInterestService;
    }

//    public List<UserInterestDTO> userSignUpInterests(SignUpUserInterestDTO interests) {
//
//        if (interests == null) {}
//    }
}
