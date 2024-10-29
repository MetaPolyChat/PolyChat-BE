package com.polychat.polychatbe.interest.query.service;

import com.polychat.polychatbe.interest.command.application.dto.InterestDTO;
import com.polychat.polychatbe.interest.command.domain.model.Interest;
import com.polychat.polychatbe.interest.command.domain.model.UserInterest;
import com.polychat.polychatbe.interest.query.repository.InterestMapper;
import com.polychat.polychatbe.interest.query.repository.UserInterestMapper;
import com.polychat.polychatbe.user.command.domain.model.User;
import com.polychat.polychatbe.user.command.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class InterestFindService {

    private InterestMapper interestMapper;
    private UserInterestMapper userInterestMapper;

    // user Mapper 완성되면 삭제하기
    private UserRepository userRepository;

    public InterestFindService(InterestMapper interestMapper, UserInterestMapper userInterestMapper, UserRepository userRepository) {
        this.interestMapper = interestMapper;
        this.userInterestMapper = userInterestMapper;
        this.userRepository = userRepository;
    }

    /*
    *   Interest Query
    * */
    // 관심사 전체 목록 호출
    public List<InterestDTO> findAllInterests() {
        return interestMapper.findAllInterests();
    }

    // Id로 관심사 조회
    public Interest findInterestByInterestNo(Long interestNo) {
        return interestMapper.findInterestByNo(interestNo);
    }

    // 이름으로 관심사 조회
    public Interest findInterestByInterestName(String interestName) {
        return interestMapper.findInterestByName(interestName);
    }

    // 이름으로 관심사 Id 조회
    public Long findInterestNoByInterestName(String interestName) {
        return interestMapper.findInterestNoByName(interestName);
    }

    // Id로 관심사 이름 조회
    public String findInterestNameByInterestNo(Long interestNo) {
        return interestMapper.findInterestNameByNo(interestNo);
    }

    /*
    *   UserInterest Query
    * */
    // userName 으로 유저-관심가 관계 찾기
    public List<UserInterest> findUserInterestsByUserId(String userId) {
        return userInterestMapper.findInterestsByUserId(userId);
    }

    // interestName 으로 유저-관심사 관계 찾기
    public List<UserInterest> findUserInterestByInterestName(String interestName) {
        return userInterestMapper.findInterestByInterestName(interestName);
    }

    // userName, interestName 으로 유저-관심사 관계 찾기
//    public UserInterest findUserInterestByUserAndInterest(String userId, String interestName) {
//        if(userId == null || interestName == null) {
//            return null;
//        }
//        return userInterestMapper.findByUserIdAndInterestName(userId, interestName);
//    }

    // 관심사 이름으로 유저 조회
    public List<User> findUsersByInterestName(String interestName) {
        List<Long> userNos = new ArrayList<>();
        List<User> users = new ArrayList<>();

        userNos = userInterestMapper.findUserNoByInterestName(interestName);
        for(Long userNo : userNos) {
            // 이 부분 user Mapper 만들면 대치 예정
            users.add(userRepository.findById(userNo).orElseThrow(()
                    -> new NoSuchElementException("findUsersByInterestName: User not found")));
        }
        return users;
    }

}
