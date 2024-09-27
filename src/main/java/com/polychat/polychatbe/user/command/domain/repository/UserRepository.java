package com.polychat.polychatbe.user.command.domain.repository;

import com.polychat.polychatbe.user.command.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmailAndStatus(String email, String status);

    Optional<User> findByEmail(String email);

    Optional<User> findByUserName(String name);

    Optional<User> findByPlanet(String planet);
}
