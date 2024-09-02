package com.polychat.polychatbe.matchingHistory.command.domain.service;

import com.polychat.polychatbe.matchingHistory.command.domain.model.MatchingHistory;
import com.polychat.polychatbe.matchingHistory.command.domain.repository.MatchingHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MatchingHistoryDomainService {

    private final MatchingHistoryRepository matchingHistoryRepository;

    public MatchingHistoryDomainService(MatchingHistoryRepository matchingHistoryRepository) {
        this.matchingHistoryRepository = matchingHistoryRepository;
    }

    //create
    public void createNewMatchingHistory(MatchingHistory matchingHistory) {
        matchingHistoryRepository.save(matchingHistory);
    }

    //read
    public List<MatchingHistory> findMatchingHistory(Long userId) {
        return matchingHistoryRepository.findByUserNumFooOrUserNumBar(userId,userId);
    }

    public MatchingHistory findMatchingHistoryById(Long matchingId) {
        return matchingHistoryRepository.findById(matchingId).orElseThrow(()->
                new NoSuchElementException("존재하는 매칭 히스토리가 없습니다.")
        );
    }

    public List<MatchingHistory> findAllMatchingHistory() {
        return matchingHistoryRepository.findAll();
    }

    //update
    public void updateMatchingHistory(MatchingHistory matchingHistory) {
        throw new IllegalStateException("히스토리는 업데이트 될 수 없습니다.");

    }

    //delete
    public void deleteMatchingHistory(Long matchingId) {
        matchingHistoryRepository.deleteById(matchingId);
    }
}
