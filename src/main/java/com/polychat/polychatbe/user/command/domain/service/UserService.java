package com.polychat.polychatbe.user.command.domain.service;

import com.polychat.polychatbe.user.command.application.dto.UserRequestDTO;
import com.polychat.polychatbe.user.command.application.dto.UserResponseDTO;
import com.polychat.polychatbe.user.command.domain.model.Authority;
import com.polychat.polychatbe.user.command.domain.model.LoginType;
import com.polychat.polychatbe.user.command.domain.model.Status;
import com.polychat.polychatbe.user.command.domain.model.User;
import com.polychat.polychatbe.user.command.domain.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

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
        userRepository.findUserByEmailAndStatus(user.email(), "ACTIVATED")
                .ifPresent(foundUser -> {
                    foundUser.setStatus(Status.DEACTIVATED);
                    userRepository.save(foundUser);
                });
    }

    @Transactional
    public void activateUser(UserRequestDTO.userDataDTO user) {
        userRepository.findUserByEmailAndStatus(user.email(), "DEACTIVATED")
                .ifPresent(foundUser -> {
                    foundUser.setStatus(Status.ACTIVATED);
                    userRepository.save(foundUser);
                });
    }

    @Transactional
    public void renameUser(UserRequestDTO.userDataDTO user, String newName) {
        userRepository.findByEmail(user.email())
                .ifPresent(foundUser -> {
                    foundUser.setUserName(newName);
                    userRepository.save(foundUser);
                });

    }

    @Transactional
    public void renameUserPlanet(UserRequestDTO.userDataDTO user, String newName) {
        userRepository.findByEmail(user.email()).ifPresent(foundUser -> {
            foundUser.setPlanet(newName);
            userRepository.save(foundUser);
        });
    }

    public Optional<User> findUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }

}
