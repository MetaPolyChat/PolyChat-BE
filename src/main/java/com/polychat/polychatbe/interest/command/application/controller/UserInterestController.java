package com.polychat.polychatbe.interest.command.application.controller;

import com.polychat.polychatbe.interest.command.application.dto.InterestDTO;
import com.polychat.polychatbe.interest.command.application.dto.SignUpUserInterestDTO;
import com.polychat.polychatbe.interest.command.application.dto.UserInterestDTO;
import com.polychat.polychatbe.interest.command.application.service.InterestUserService;
import com.polychat.polychatbe.interest.command.domain.model.Interest;
import com.polychat.polychatbe.interest.command.domain.service.InterestService;
import com.polychat.polychatbe.interest.command.domain.service.UserInterestService;
import com.polychat.polychatbe.interest.query.service.InterestFindService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Tag(name="유저 관심사 관리 API", description = "아직 등록 밖에 없음")
@RequestMapping("/interest")
public class UserInterestController {

    private InterestFindService interestFindService;
    private InterestService interestService;

    private InterestUserService interestUserService;

    public UserInterestController(InterestService interestService, InterestUserService interestUserService, InterestFindService interestFindService) {
        this.interestService = interestService;
        this.interestUserService = interestUserService;
        this.interestFindService = interestFindService;
    }

    // 최초 로그인 시 관심사 등록 화면
    @Operation(summary = "관심사 등록", description = "관심사 등록 api")
    @PostMapping("/regist")
    public ResponseEntity<?> registerInterest(@RequestBody SignUpUserInterestDTO signUpInterestDTO) {
        System.out.println(signUpInterestDTO);
        log.info("signUpInterestDTO", signUpInterestDTO );
        if (signUpInterestDTO == null)
            return ResponseEntity.badRequest().build();
        interestUserService.regist(signUpInterestDTO);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "전체 관심사 조회", description = "DB에 저장된 전체 api")
    @GetMapping("/find-all")
    public ResponseEntity<?> listInterest() {
        log.info("listInterest");

        System.out.println(interestFindService.findAllInterests());
        return ResponseEntity.ok().body(interestFindService.findAllInterests());
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
