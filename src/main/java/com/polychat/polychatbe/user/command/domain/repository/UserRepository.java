package com.polychat.polychatbe.user.command.domain.repository;

import com.polychat.polychatbe.user.command.domain.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findUserById(long userId) {
        return em.find(User.class, userId);
    }
}
