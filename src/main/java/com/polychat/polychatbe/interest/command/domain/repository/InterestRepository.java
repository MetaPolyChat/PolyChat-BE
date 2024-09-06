package com.polychat.polychatbe.interest.command.domain.repository;

import com.polychat.polychatbe.interest.command.domain.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {
    Interest findByInterestName(String interestName);
//    Optional<Interest> findByInterestId(Long interestNo);
}
