package com.polychat.polychatbe.inerest.command.domain.repository;
import com.polychat.polychatbe.inerest.command.domain.model.UserInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInterestRepository extends JpaRepository<UserInterest, Long> {

}
