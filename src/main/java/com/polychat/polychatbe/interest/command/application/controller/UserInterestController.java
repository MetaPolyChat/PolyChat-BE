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

    private final UserInterestService userInterestService;
    private InterestFindService interestFindService;
    private InterestService interestService;

    private InterestUserService interestUserService;

    public UserInterestController(InterestService interestService, InterestUserService interestUserService, InterestFindService interestFindService, UserInterestService userInterestService) {
        this.interestService = interestService;
        this.interestUserService = interestUserService;
        this.interestFindService = interestFindService;
        this.userInterestService = userInterestService;
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

    @Operation(summary = "전체 유저 관심사 조회", description = "DB에 저장된 전체 api")
    @GetMapping("/find-all")
    public ResponseEntity<?> listInterest() {
        log.info("listInterest");

        System.out.println(interestFindService.findAllInterests());
        return ResponseEntity.ok().body(interestFindService.findAllInterests());
    }

    @Operation(summary = "유저의 관심사 목록 id 조회", description = "유저의 관심사 id를 리스트 형태로 반환")
    @GetMapping("/user-list")
    public ResponseEntity<?> listUserInterest(@RequestParam Long userId) {
        log.info("listUserInterest");

        List<Long> result = interestUserService.findInterestByUserId(userId);

        if (result.size() == 0) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "유저의 관심사 불러오기", description = "유저의 관심사를 리스트 형태로 반환")
    @GetMapping("/user")
    public ResponseEntity<?> listUserInterestName(@RequestParam Long userId) {
        log.info("listUserInterest string");

        List<String> result = interestUserService.findInterestNamesByUserId(userId);

        return ResponseEntity.ok().body(result);
    }

//    @Operation(summary = "유저 관심사 조회", description = "유저의 관심사 조회 api")
//    @GetMapping("/find-by-user/")
//    public ResponseEntity<?> findInterestByUser(@RequestParam String userId) {
//
//        InterestUserService
//        return ResponseEntity.ok().build();
//    }

//    @Operation(summary = "관심사 수정", description = "관심사 수정 api")
//    @PutMapping("/update")
//    public ResponseEntity<?> updateInterest(@RequestBody InterestDTO interest) {
//
//    }
//
//    @GetMapping("/find-user")
//    public
}
