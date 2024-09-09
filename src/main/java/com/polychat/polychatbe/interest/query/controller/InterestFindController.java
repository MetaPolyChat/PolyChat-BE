package com.polychat.polychatbe.interest.query.controller;

import com.polychat.polychatbe.interest.query.service.InterestFindService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interest/find")
public class InterestFindController {

    private final InterestFindService interestFindService;

    public InterestFindController(InterestFindService interestFindService) {
        this.interestFindService = interestFindService;
    }

    @Operation(summary = "모든 관심사 출력", description = "DB에 저장된 모든 관심사를 출력합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "모든 관심사를 불러오는데 성공했습니다."),
            @ApiResponse(responseCode = "400", description = "관심사를 찾는데 실패했습니다.")
    })
    @GetMapping("/all-interests")
    public ResponseEntity<?> findAllInterests() {

        return ResponseEntity.ok().body(interestFindService.findAllInterests());
    }

    @Operation(summary = "유저Id로 관심사 목록 출력", description = "유저의 관심사 목록을 출력합니다.")
    @GetMapping("/by-user")
    public ResponseEntity<?> findInterestsByUser(@RequestParam String userId) {

        return ResponseEntity.ok().body(interestFindService.findUserInterestsByUserId(userId));
    }

    @Operation(summary = "관심사 이름으로 목록 출력", description = "관심사 이름으로 관심사 목록을 출력합니다.")
    @GetMapping("/by-interest")
    public ResponseEntity<?> findInterestsByInterest(@RequestParam String interestName) {

        return ResponseEntity.ok().body(interestFindService.findUserInterestByInterestName(interestName));
    }

//    @Operation(summary = "유저명 & 관심사 이름으로 목록 출력", description = "유저명과 관심사 이름으로 목록을 출력합니다.")
//    @GetMapping("by-user-interest")
//    public ResponseEntity<?> findInterestsByUserAndInterest(
//            @RequestParam String userId, @RequestParam String interestName) {
//
//        return ResponseEntity.ok().body(interestFindService.findUserInterestByUserAndInterest(userId, interestName));
//    }

    @Operation(summary = "관심사를 가진 유저 목록 출력", description = "관심사에 해당하는 유저의 목록을 출력합니다.")
    @GetMapping("/user-by-interest")
    public ResponseEntity<?> findUsersByInterest(@RequestParam String interestName) {

        return ResponseEntity.ok().body(interestFindService.findUsersByInterestName(interestName));
    }


}
