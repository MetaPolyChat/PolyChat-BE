package com.polychat.polychatbe.inerest.command.domain.repository;

import com.polychat.polychatbe.inerest.command.domain.model.Interest;
import com.polychat.polychatbe.inerest.command.domain.model.UserInterest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InterestRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveInterest(Interest interest) {
        entityManager.persist(interest);
    }

    public void saveUserInterest(UserInterest userInterest) {
        entityManager.persist(userInterest);
    }

    public Interest findInterestById(Long interestId) {
        return entityManager.find(Interest.class, interestId);
    }

    public List<Interest> findAllInterestsByUserId(Long userId) {
        return entityManager.createQuery("select i from UserInterest i where i.userId = :userId")
                .setParameter("userId", Long.valueOf(userId))
                .getResultList();   // 이부분 잘 모르겠음
    }
}
