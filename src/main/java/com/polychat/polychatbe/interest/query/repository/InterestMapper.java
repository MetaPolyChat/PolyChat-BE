package com.polychat.polychatbe.interest.query.repository;

import com.polychat.polychatbe.interest.command.domain.model.Interest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterestMapper {
    List<Interest> findAllInterests();
    Interest findInterestByNo(Long interestNo);
    Interest findInterestByName(String interestName);
    Long findInterestNoByName(String interestName);
    String findInterestNameByNo(Long interestNo);
}
