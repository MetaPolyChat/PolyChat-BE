package com.polychat.polychatbe.interest.query.repository;

import com.polychat.polychatbe.interest.command.domain.model.UserInterest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInterestMapper {

    List<UserInterest> findByUserNo(Long userNo);
    List<UserInterest> findByInterestNo(Long interestNo);
    UserInterest findByUserNoAndInterestNo(Long userNo, Long interestNo);
    UserInterest findByNo(Long refInterestNo);
}
