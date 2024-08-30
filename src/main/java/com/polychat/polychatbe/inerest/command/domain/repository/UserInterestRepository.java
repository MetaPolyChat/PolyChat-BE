package com.polychat.polychatbe.inerest.command.domain.repository;
import com.polychat.polychatbe.inerest.command.domain.model.UserInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInterestRepository extends JpaRepository<UserInterest, Long> {
    UserInterest findByUserNoAndInterestNo(Long userNo, Long interestNo);
    List<UserInterest> findByInterestNo(Long interestNo);
}
