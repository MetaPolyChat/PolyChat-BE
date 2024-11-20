package com.polychat.polychatbe.matchingHistory.command.application.controller;

import com.polychat.polychatbe.matchingHistory.command.application.dto.CreateMatchingHistoryDTO;
import com.polychat.polychatbe.matchingHistory.command.application.dto.MatchingHistoryDTO;
import com.polychat.polychatbe.matchingHistory.command.application.dto.ReadMatchingHistoryDTO;
import com.polychat.polychatbe.matchingHistory.command.application.service.MatchingHistoryAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/history")
@RestController
@Tag(name = "매칭 히스토리", description = "유저들끼리나 ai 상대로 채팅 매칭된 기록")
public class MatchingHistoryController {

    private final MatchingHistoryAppService appService;

    @Operation(summary = "모든 기록", description = "모든 기록을 불러옵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 처리 되었습니다."),
            @ApiResponse(responseCode = "500", description = "예상치 못한 예러")
    })
    @GetMapping("/list")
    public ResponseEntity<?> findAllList() {
        List<MatchingHistoryDTO> result = appService.findAllHistory();
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "유저 기록", description = "유저의 모든 기록을 불러옵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 처리 되었습니다."),
            @ApiResponse(responseCode = "500", description = "예상치 못한 예러")
    })
    @GetMapping("/user")
    public ResponseEntity<?>  findHistory(@RequestParam String userId) {
        List<ReadMatchingHistoryDTO> result = appService.findMatchingHistory(Long.parseLong(userId));
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "기록 입력", description = "매칭 기록을 입력합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 처리 되었습니다."),
            @ApiResponse(responseCode = "500", description = "예상치 못한 예러")
    })
    @PostMapping("/create")
    public ResponseEntity<?> createHistory(@RequestBody CreateMatchingHistoryDTO createDto) {
        MatchingHistoryDTO created = appService.createNewMatchingHistory(createDto);
        return ResponseEntity.ok(created);
    }

    @Operation(summary = "기록 입력", description = "매칭 기록을 입력합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 처리 되었습니다."),
            @ApiResponse(responseCode = "500", description = "예상치 못한 예러")
    })
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteHistory(@RequestParam Long historyId) {
        appService.deleteMatchingHistory(historyId);
        return ResponseEntity.ok().build();
    }


}
