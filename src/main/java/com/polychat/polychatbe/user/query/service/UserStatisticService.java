package com.polychat.polychatbe.user.query.service;

import com.polychat.polychatbe.user.query.dto.RegistPerDayDTO;
import com.polychat.polychatbe.user.query.repository.UserSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStatisticService {
    private UserSearchRepository userSearchRepository;

    public UserStatisticService(UserSearchRepository userSearchRepository) {
        this.userSearchRepository = userSearchRepository;
    }

    public List<RegistPerDayDTO> countRegisterDayRange(int range){
        return userSearchRepository.registerCountDayRange(range);
    }
}
