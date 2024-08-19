package com.polychat.polychatbe.inerest.command.domain.service;

import com.polychat.polychatbe.inerest.command.domain.model.Interest;
import com.polychat.polychatbe.inerest.command.domain.model.UserInterest;
import com.polychat.polychatbe.inerest.command.domain.repository.InterestRepository;
import com.polychat.polychatbe.inerest.command.domain.repository.UserInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InterestService {

    private InterestRepository interestRepository;
    private UserInterestRepository userInterestRepository;

    @Autowired
    public InterestService(InterestRepository interestRepository, UserInterestRepository userInterestRepository) {
        this.interestRepository = interestRepository;
        this.userInterestRepository = userInterestRepository;
    }


    @Transactional
    public void registInterest(String InterestName) {   // 유효한 문자열인지 검증 필요
        interestRepository.save(new Interest(InterestName));
    }

    @Transactional
    public void registUserInterest(Long userId, Long interestId) {  // 존재하는 관심사인지 검증 필요
        userInterestRepository.save(new UserInterest(userId, interestId));
//        UserInterest userInterest = new UserInterest(userId, interestId);
//        interestRepository.saveUserInterest(userInterest);
    }

//    public List<Interest> findUserInterestsByUserId(Long userId) {
//        return interestRepository.findAllById(userId);
//    }
//
//    public Interest findInterestById(Long interestId) {
//        return interestRepository.findInterestById(interestId);
//    }
}
