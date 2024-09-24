package com.polychat.polychatbe.interest.command.application.controller;

import com.polychat.polychatbe.interest.command.application.dto.InterestDTO;
import com.polychat.polychatbe.interest.command.application.dto.SignUpUserInterestDTO;
import com.polychat.polychatbe.interest.command.application.dto.UserInterestDTO;
import com.polychat.polychatbe.interest.command.domain.service.InterestService;
import com.polychat.polychatbe.interest.command.domain.service.UserInterestService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "관심사 경로", description = "관심사 등록 api")
    @PostMapping("/regist")
    public ResponseEntity<?> registerInterest(@RequestBody SignUpUserInterestDTO interest) {

        if (interest == null)
            return ResponseEntity.badRequest().build();
//        List<UserInterestDTO> result = userInterestService.registUserInterest(interest);
//        return ResponseEntity.ok(result);
        return ResponseEntity.ok().build();
    }

//    @Operation(summary = "관심사 수정", description = "관심사 수정 api")
//    @PutMapping("/update")
//    public ResponseEntity<?> updateInterest(@RequestBody InterestDTO interest) {
//
//    }
//
//    @GetMapping("/find-user")
//    public
}
