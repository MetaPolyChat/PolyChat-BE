package com.polychat.polychatbe.matchingHistory.command.domain.service;

import com.polychat.polychatbe.matchingHistory.command.domain.repository.MatchingHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class MatchingHistoryDomainService {

    private MatchingHistoryRepository matchingHistoryRepository;

    public MatchingHistoryDomainService(MatchingHistoryRepository matchingHistoryRepository) {
        this.matchingHistoryRepository = matchingHistoryRepository;
    }


}
