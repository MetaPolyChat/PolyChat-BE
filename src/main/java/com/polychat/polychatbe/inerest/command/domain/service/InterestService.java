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


    @Transactional  // 관심사 종류 등록
    public void registInterest(String InterestName) {   // 유효한 문자열인지 검증 필요
        interestRepository.save(new Interest(InterestName));
    }

    @Transactional  // 관심사 종류 삭제
    public void removeInterest(Interest interest) {
        List<UserInterest> userInterests = userInterestRepository.findByInterestNo(interest.getInterestNo());
        if (userInterests.isEmpty()) {
            throw new IllegalArgumentException();   // 발생시킬 에러 내용 작성
        }
        interestRepository.deleteById(interest.getInterestNo());
        userInterestRepository.deleteAll(userInterests);    // 해당 관심사를 가지는 모든 유저와의 관계 제거
    }

    @Transactional
    public void updateInterest(String interestName) {
        Interest interest = interestRepository.findByInterestName(interestName);
        interest.updateInterest(interest);
        interestRepository.save(interest);
    }

    public List<Interest> findAllInterests() {
        return interestRepository.findAll();
    }

    public Interest findInterestByInterestNo(Long interestNo) {
        Interest interest = interestRepository.findById(interestNo).orElseThrow(IllegalArgumentException::new);
        return interest;
    }

    public Interest findInterestByInterestName(String interestName) {
        Interest interest = interestRepository.findByInterestName(interestName);
    }
}
