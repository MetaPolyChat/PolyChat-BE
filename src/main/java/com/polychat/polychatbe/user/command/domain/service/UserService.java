package com.polychat.polychatbe.user.command.domain.service;

import com.polychat.polychatbe.user.command.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
