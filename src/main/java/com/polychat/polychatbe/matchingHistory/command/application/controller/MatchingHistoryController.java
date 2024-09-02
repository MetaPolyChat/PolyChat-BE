package com.polychat.polychatbe.matchingHistory.command.application.controller;

import com.polychat.polychatbe.matchingHistory.command.application.dto.MatchingHistoryDTO;
import com.polychat.polychatbe.matchingHistory.command.application.service.MatchingHistoryAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class MatchingHistoryController {

    private final MatchingHistoryAppService matchingHistoryAppService;

    public MatchingHistoryController(MatchingHistoryAppService matchingHistoryAppService) {
        this.matchingHistoryAppService = matchingHistoryAppService;
    }

//    @GetMapping(value = "/user", produces = "application/json; charset=UTF-8")
//    @ResponseBody()
//    public List<MatchingHistoryDTO> getMatchingHistoryByUserIdToJson(@RequestParam String userId) {
//        return matchingHistoryAppService.findMatchingHistory(Long.parseLong(userId));
//    }

    @GetMapping(value = "/history/user", produces = "application/json; charset=UTF-8")
    public ResponseEntity getMatchingHistoryByUserIdToJson(@RequestParam String userId) {
        List<MatchingHistoryDTO> result = matchingHistoryAppService.findMatchingHistory(Long.parseLong(userId));
        if (result.size() > 0) {
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.status(400).body("{\"message\" : \"조회실패\"}");
        }
    }


}
