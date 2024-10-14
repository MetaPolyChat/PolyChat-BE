package com.polychat.polychatbe.user.query.service;

import com.polychat.polychatbe.common.SearchCriteriaInfo;
import com.polychat.polychatbe.user.query.dto.UserDetailResponseDTO;
import com.polychat.polychatbe.user.query.dto.UserResponseDTO;
import com.polychat.polychatbe.user.query.repository.UserSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
        return userSearchRepository.findUsersWithCriteria(searchCriteriaInfo);
    }

    public int countAll(){
        return userSearchRepository.countAll();
    }

    public UserDetailResponseDTO findUserById(long id){
        return userSearchRepository.findUserById(id).orElseThrow(
                ()->new NoSuchElementException("해당 유저를 찾을 수 없습니다")
        );
    }


}
