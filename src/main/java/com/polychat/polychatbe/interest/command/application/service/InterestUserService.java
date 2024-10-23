package com.polychat.polychatbe.interest.command.application.service;

import com.polychat.polychatbe.interest.command.application.dto.InterestDTO;
import com.polychat.polychatbe.interest.command.application.dto.SignUpUserInterestDTO;
import com.polychat.polychatbe.interest.command.application.dto.UserInterestDTO;
import com.polychat.polychatbe.interest.command.domain.model.Interest;
import com.polychat.polychatbe.interest.command.domain.service.UserInterestService;
import com.polychat.polychatbe.interest.query.service.InterestFindService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestUserService {

    private UserInterestService userInterestService;
    private InterestFindService interestFindService;

    public InterestUserService(UserInterestService userInterestService, InterestFindService interestFindService) {
        this.userInterestService = userInterestService;
        this.interestFindService = interestFindService;
    }

    public void regist(SignUpUserInterestDTO signUpUserInterestDTO) {
        List<Long> interests = signUpUserInterestDTO.getInterestList();

        for ( Long interestId: interests ) {
            userInterestService.registUserInterest(signUpUserInterestDTO.getUserId(), interestId);
        }
    }

    public List<InterestDTO> findAllInterest() {
        return interestFindService.findAllInterests();
    }

//    public List<UserInterestDTO> userSignUpInterests(SignUpUserInterestDTO interests) {
//
//        if (interests == null) {}
//    }
}
