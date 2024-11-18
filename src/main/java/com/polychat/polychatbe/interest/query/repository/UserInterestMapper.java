package com.polychat.polychatbe.interest.query.repository;

import com.polychat.polychatbe.interest.command.domain.model.UserInterest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInterestMapper {

    List<UserInterest> findInterestsByUserId(String userId);
    List<UserInterest> findUserInterestsByUserId(String interestName);

    // 값 안 들어오는 경우 혹은 빈문자열 인 경우 예외처리
//    UserInterest findByUserIdAndInterestName(String userId, String interestName);

    // find User(No) list by InterestNo
    List<Long> findUserIdByInterestName(String interestName);
    List<Long> findUsersAllInterestIdByUserId(Long userId);
    List<Long> findAllUserByInterestId(Long interestId);
}
