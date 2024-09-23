package com.polychat.polychatbe.interest.command.application.controller;

import com.polychat.polychatbe.interest.command.application.dto.SignUpUserInterestDTO;
import com.polychat.polychatbe.interest.command.application.dto.UserInterestDTO;
import com.polychat.polychatbe.interest.command.domain.service.InterestService;
import com.polychat.polychatbe.interest.command.domain.service.UserInterestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/interest")
public class UserInterestController {

    private InterestService interestService;

    private UserInterestService userInterestService;

    public UserInterestController(InterestService interestService, UserInterestService userInterestService) {
        this.interestService = interestService;
        this.userInterestService = userInterestService;
    }

    @PostMapping("/regist")
    public ResponseEntity<?> registerInterest(@RequestBody SignUpUserInterestDTO interest) {

        if (interest == null)
            return ResponseEntity.badRequest().build();
//        List<UserInterestDTO> result = userInterestService.registUserInterest(interest);
//        return ResponseEntity.ok(result);
        return ResponseEntity.ok().build();
    }
}
