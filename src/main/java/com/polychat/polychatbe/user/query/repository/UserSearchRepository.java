package com.polychat.polychatbe.user.query.repository;

import com.polychat.polychatbe.common.SearchCriteriaInfo;
import com.polychat.polychatbe.user.query.dto.UserDetailResponseDTO;
import com.polychat.polychatbe.user.query.dto.UserResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserSearchRepository {

    List<UserResponseDTO> findAllUser();
    List<UserResponseDTO> findUsersWithCriteria(SearchCriteriaInfo searchCriteriaInfo);
    Optional<UserDetailResponseDTO> findUserById(long id);
    int countAll();

}
