package com.polychat.polychatbe.user.query.service;

import com.polychat.polychatbe.common.SearchCriteriaInfo;
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

    public List<UserResponseDTO> findUsersWithCriteria(SearchCriteriaInfo searchCriteriaInfo) {
        System.out.println("시도중");
        return userSearchRepository.findUsersWithCriteria(searchCriteriaInfo);
    }

    public int countAll() {
        System.out.println("카운트 시도?");
        int counted = userSearchRepository.countAll();
        System.out.println("카운트 : " + counted);
        return counted;
    }


}
