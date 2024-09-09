package com.polychat.polychatbe.interest.query.repository;

import com.polychat.polychatbe.interest.command.domain.model.Interest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterestMapper {
    List<Interest> findAll();
    Interest findByNo(Long no);
    Interest findByName(String name);
}
