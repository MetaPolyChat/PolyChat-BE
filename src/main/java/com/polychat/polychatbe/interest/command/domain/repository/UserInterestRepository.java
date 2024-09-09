package com.polychat.polychatbe.interest.command.domain.repository;
import com.polychat.polychatbe.interest.command.domain.model.UserInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInterestRepository extends JpaRepository<UserInterest, Long> {
    UserInterest findByUserNoAndInterestNo(Long userNo, Long interestNo);
    List<UserInterest> findAllByInterestNo(Long interestNo);
}