package com.polychat.polychatbe.matchingHistory.command.application.controller;

import com.polychat.polychatbe.matchingHistory.command.application.service.MatchingHistoryAppService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchingHistoryController {

    MatchingHistoryAppService matchingHistoryAppService;

    public MatchingHistoryController(MatchingHistoryAppService matchingHistoryAppService) {
        this.matchingHistoryAppService = matchingHistoryAppService;
    }


}
