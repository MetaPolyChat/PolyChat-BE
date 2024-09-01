package com.polychat.polychatbe.matchingHistory.command.application.service;

import com.polychat.polychatbe.matchingHistory.command.domain.model.MatchingHistory;
import com.polychat.polychatbe.matchingHistory.command.domain.service.MatchingHistoryDomainService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchingHistoryAppService {

    MatchingHistoryDomainService matchingHistoryDomainService;

    public MatchingHistoryAppService(MatchingHistoryDomainService matchingHistoryDomainService) {
        this.matchingHistoryDomainService = matchingHistoryDomainService;
    }

    //create
    public void createNewMatchingHistory(MatchingHistoryDTO matchingHistoryDTO) {
        MatchingHistory matchingHistory = new MatchingHistory(
                matchingHistoryDTO.getUserNumFoo(),
                matchingHistoryDTO.getUserNumBar(),
                matchingHistoryDTO.getMatchTime(),
                matchingHistoryDTO.isAiMatch()
        );
        matchingHistoryDomainService.createNewMatchingHistory(matchingHistory);
    }

    //read
    public List<MatchingHistory> findMatchingHistory(Long userId) {
        return matchingHistoryDomainService.findMatchingHistory(userId);
    }


}
