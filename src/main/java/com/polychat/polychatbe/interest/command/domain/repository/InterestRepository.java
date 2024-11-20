package com.polychat.polychatbe.interest.command.domain.repository;

import com.polychat.polychatbe.interest.command.domain.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {
    // JPA repository
    Interest findByInterestName(String interestName);

    List<Interest> findInterestNameByInterestIdIn(List<Long> interestIds);
}
