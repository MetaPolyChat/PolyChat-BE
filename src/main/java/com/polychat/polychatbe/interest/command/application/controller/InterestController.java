package com.polychat.polychatbe.interest.command.application.controller;

import com.polychat.polychatbe.interest.command.domain.service.InterestService;
import com.polychat.polychatbe.interest.command.domain.service.UserInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interest")
public class InterestController {

    private InterestService interestService;

    private UserInterestService userInterestService;

    public InterestController(InterestService interestService, UserInterestService userInterestService) {
        this.interestService = interestService;
        this.userInterestService = userInterestService;
    }

//    @PostMapping("/regist")
//    public ResponseEntity registerInterest(@RequestBody Interest interest) {
//
//    }
}
