package com.polychat.polychatbe.interest.command.application.service;

import com.polychat.polychatbe.common.error.ApplicationException;
import com.polychat.polychatbe.common.error.ErrorCode;
import com.polychat.polychatbe.interest.command.application.dto.InterestDTO;
import com.polychat.polychatbe.interest.command.application.dto.SignUpUserInterestDTO;
import com.polychat.polychatbe.interest.command.application.dto.UserInterestDTO;
import com.polychat.polychatbe.interest.command.domain.model.Interest;
import com.polychat.polychatbe.interest.command.domain.model.UserInterest;
import com.polychat.polychatbe.interest.command.domain.service.InterestService;
import com.polychat.polychatbe.interest.command.domain.service.UserInterestService;
import com.polychat.polychatbe.interest.query.service.InterestFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InterestUserService {

    private final UserInterestService userInterestService;
    private final InterestFindService interestFindService;
    private final InterestService interestService;

    public void regist(SignUpUserInterestDTO signUpUserInterestDTO) {
        List<Long> interests = signUpUserInterestDTO.getInterestList();

        for ( Long interestId: interests ) {
            userInterestService.registUserInterest(signUpUserInterestDTO.getUserId(), interestId);
        }
    }

    public List<InterestDTO> findAllInterest() {
        return interestFindService.findAllInterests();
    }

    public List<Long> findInterestByUserId(Long userId) {
        return interestFindService.findAllInterestIdsByUserId(userId);
    }

    public List<String> findInterestNamesByUserId(Long userId) {
        List<Long> interestIds = findInterestByUserId(userId);
        if (interestIds.isEmpty()) {
            throw new ApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
        List<Interest> interests = interestService.findInterestNameByInterestIdIn(interestIds);
        List<String> interestNames = new ArrayList<>();
        for ( Interest interest: interests ) {
            interestNames.add(interest.getInterestName());
        }
        return interestNames;
    }

//    public List<UserInterestDTO> userSignUpInterests(SignUpUserInterestDTO interests) {
//
//        if (interests == null) {}
//    }
}
