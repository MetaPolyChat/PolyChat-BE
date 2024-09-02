package com.polychat.polychatbe.matchingHistory.command.domain.repository;

import com.polychat.polychatbe.matchingHistory.command.domain.model.MatchingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchingHistoryRepository extends JpaRepository<MatchingHistory, Long> {
    List<MatchingHistory> findUserNumFooOrUserNumBarByMatchingId(Long matchId);
}
