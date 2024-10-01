package com.polychat.polychatbe.user.command.domain.service;

import com.polychat.polychatbe.user.command.application.dto.UserRequestDTO;
import com.polychat.polychatbe.user.command.domain.model.Authority;
import com.polychat.polychatbe.user.command.domain.model.LoginType;
import com.polychat.polychatbe.user.command.domain.model.Status;
import com.polychat.polychatbe.user.command.domain.model.User;
import com.polychat.polychatbe.user.command.domain.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Transactional
    public boolean saveUser(UserRequestDTO.signUpDTO user) {

        if (userRepository.findByEmail(user.email()).isPresent()) {
            return false;
        }

        User newUser = newUser(user);

        userRepository.save(newUser);

        return true;
    }

    // 회원 생성
    protected User newUser(UserRequestDTO.signUpDTO requestDTO) {
        return User.builder()
                .userName(requestDTO.name())
                .email(requestDTO.email())
                .password(passwordEncoder.encode(requestDTO.password()))
                .loginType(LoginType.NONE)
                .authority(Authority.USER)
                .status(Status.ACTIVATED)
                .build();
    }

    @Transactional
    public void deactivateUser(UserRequestDTO.userDataDTO user) {
        userRepository.findUserByEmailAndStatus(user.email(), String.valueOf(Status.ACTIVATED))
                .ifPresent(foundUser -> {
                    foundUser.updateStatus(Status.DEACTIVATED);
                    userRepository.save(foundUser);
                });
    }

    @Transactional
    public void activateUser(UserRequestDTO.userDataDTO user) {
        userRepository.findUserByEmailAndStatus(user.email(), String.valueOf(Status.DEACTIVATED))
                .ifPresent(foundUser -> {
                    foundUser.updateStatus(Status.ACTIVATED);
                    userRepository.save(foundUser);
                });
    }

    @Transactional
    public void renameUser(UserRequestDTO.userDataDTO user, String newName) {
        userRepository.findByEmail(user.email())
                .ifPresent(foundUser -> {
                    foundUser.updateUserName(newName);
                    userRepository.save(foundUser);
                });

    }


    public Optional<User> findUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    public User findUserByUserName(String name) {
        return userRepository.findByUserName(name).orElse(null);
    }

    public User findUserByPlanet(String planet) {
        return userRepository.findByPlanet(planet).orElse(null);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
