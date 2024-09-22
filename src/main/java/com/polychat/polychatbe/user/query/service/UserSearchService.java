package com.polychat.polychatbe.user.query.service;

import com.polychat.polychatbe.user.query.dto.UserResponseDTO;
import com.polychat.polychatbe.user.query.repository.UserSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchService {

    private UserSearchRepository userSearchRepository;

    public UserSearchService(UserSearchRepository userSearchRepository) {
        this.userSearchRepository = userSearchRepository;
    }

    public List<UserResponseDTO> findAllUser() {
        return userSearchRepository.findAllUser();
    }

    public int countAll() {
        return userSearchRepository.countAll();
    }


}
