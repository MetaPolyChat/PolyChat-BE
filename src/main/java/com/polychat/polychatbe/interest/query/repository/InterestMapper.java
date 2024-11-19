package com.polychat.polychatbe.interest.query.repository;

import com.polychat.polychatbe.interest.command.application.dto.InterestDTO;
import com.polychat.polychatbe.interest.command.domain.model.Interest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface InterestMapper {
    List<InterestDTO> findAllInterests();
    Interest findInterestByNo(Long interestId);
    Interest findInterestByName(String interestName);
    Long findInterestNoByName(String interestName);
    String findInterestNameByNo(Long interestId);
}
