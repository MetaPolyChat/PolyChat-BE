package com.polychat.polychatbe.interest.command.domain.service;

import com.polychat.polychatbe.interest.command.domain.model.Interest;
import com.polychat.polychatbe.interest.command.domain.model.UserInterest;
import com.polychat.polychatbe.interest.command.domain.repository.InterestRepository;
import com.polychat.polychatbe.interest.command.domain.repository.UserInterestRepository;
import com.polychat.polychatbe.interest.query.service.InterestFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InterestService {

    private final InterestFindService interestFindService;
    private InterestRepository interestRepository;
    private UserInterestRepository userInterestRepository;

    @Autowired
    public InterestService(InterestRepository interestRepository, UserInterestRepository userInterestRepository, InterestFindService interestFindService) {
        this.interestRepository = interestRepository;
        this.userInterestRepository = userInterestRepository;
        this.interestFindService = interestFindService;
    }


    @Transactional  // 관심사 종류 등록
    public Interest registInterest(String interestName) {   // 유효한 문자열인지 검증 필요
        if (interestRepository.findByInterestName(interestName) == null) {
            return interestRepository.save(new Interest(interestName));
        }

        return null;
    }

    @Transactional  // 관심사 종류 삭제
    public String removeInterest(String interestName) {
        Interest findInterest = interestRepository.findByInterestName(interestName);
        List<UserInterest> userInterests = userInterestRepository.findAllByInterestId(findInterest.getInterestId());
        if (!userInterests.isEmpty()) {
            // 해당 관심사를 가지는 모든 유저의 관심사와의 관계 제거
            userInterestRepository.deleteAll(userInterests);
        }
        interestRepository.deleteById(findInterest.getInterestId());
        return interestName;
    }

    public List<Long> findAllInterestIds() {
        return interestFindService.findAllInterestIds();
    }

    public List<Interest> findInterestNameByInterestIdIn(List<Long> interestIds){
        return interestRepository.findInterestNameByInterestIdIn(interestIds);
    }

    // 관심사 업데이트 수정 필요
//    @Transactional
//    public void updateInterest(String targetInterestName, String interestName) {
//        Interest interest = interestRepository.findByInterestName(targetInterestName);
//        if (interest != null) {
//            interest.updateInterest(interest);
//            interestRepository.save(interest);
//        }
//    }
}
