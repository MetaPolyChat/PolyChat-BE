package com.polychat.polychatbe.user.query.repository;

import com.polychat.polychatbe.common.SearchCriteriaInfo;
import com.polychat.polychatbe.user.query.dto.UserResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserSearchRepository {

    List<UserResponseDTO> findAllUser();
    //List<UserResponseDTO> findAllUserWithCriteria(SearchCriteriaInfo searchCriteriaInfo);


    int countAll();

    List<UserResponseDTO> findUsersWithCriteria(SearchCriteriaInfo searchCriteriaInfo);
}
