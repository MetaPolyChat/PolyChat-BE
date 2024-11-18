package com.polychat.polychatbe.interest.command.domain.service;

import com.polychat.polychatbe.interest.command.domain.model.Interest;
import com.polychat.polychatbe.interest.command.domain.model.UserInterest;
import com.polychat.polychatbe.interest.command.domain.repository.InterestRepository;
import com.polychat.polychatbe.interest.command.domain.repository.UserInterestRepository;
import com.polychat.polychatbe.interest.query.service.InterestFindService;
import com.polychat.polychatbe.user.command.domain.model.User;
import com.polychat.polychatbe.user.command.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInterestService {

    private final InterestFindService interestFindService;
    private UserInterestRepository userInterestRepository;
    private InterestRepository interestRepository;
    private UserRepository userRepository;

    public UserInterestService(
            UserInterestRepository userInterestRepository,
            InterestRepository interestRepository,
            UserRepository userRepository, InterestFindService interestFindService) {
        this.userInterestRepository = userInterestRepository;
        this.interestRepository = interestRepository;
        this.userRepository = userRepository;
        this.interestFindService = interestFindService;
    }

    @Transactional  // 유저의 관심사 등록
    public UserInterest registUserInterest(Long userId, Long interestId) {
        UserInterest uInter = new UserInterest(userId, interestId);
        if(userInterestRepository.findByUserIdAndInterestId(userId, interestId) == null) {
            uInter = userInterestRepository.save(uInter);
            return uInter;
        }
        return null;
    }

    @Transactional  // 유저의 관심사 삭제
    public void removeUserInterest(User user, Interest interest) {
        UserInterest userInterest = userInterestRepository
                .findByUserIdAndInterestId(
                user.getUserId(),
                interest.getInterestId()
                );
        if (userInterest != null) {
            userInterestRepository.delete(userInterest);
        }
    }

    public List<Long> getUserInterests(Long userId) {
        return interestFindService.findAllInterestIdsByUserId(userId);
    }
}
