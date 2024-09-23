package com.polychat.polychatbe.interest.command.application.controller;

import com.polychat.polychatbe.interest.command.domain.service.InterestService;
import com.polychat.polychatbe.interest.command.domain.service.UserInterestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interest")
public class UserInterestController {

    private InterestService interestService;

    private UserInterestService userInterestService;

    public UserInterestController(InterestService interestService, UserInterestService userInterestService) {
        this.interestService = interestService;
        this.userInterestService = userInterestService;
    }

//    @PostMapping("/regist")
//    public ResponseEntity registerInterest(@RequestBody Interest interest) {
//
//    }
}
