package com.polychat.polychatbe.inerest.command.domain.service;

import com.polychat.polychatbe.inerest.command.domain.model.Interest;
import com.polychat.polychatbe.inerest.command.domain.model.UserInterest;
import com.polychat.polychatbe.inerest.command.domain.repository.InterestRepository;
import com.polychat.polychatbe.inerest.command.domain.repository.UserInterestRepository;
import com.polychat.polychatbe.user.command.domain.model.User;
import com.polychat.polychatbe.user.command.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInterestService {

    private UserInterestRepository userInterestRepository;
    private InterestRepository interestRepository;
    private UserRepository userRepository;

    public UserInterestService(
            UserInterestRepository userInterestRepository,
            InterestRepository interestRepository,
            UserRepository userRepository ) {
        this.userInterestRepository = userInterestRepository;
        this.interestRepository = interestRepository;
        this.userRepository = userRepository;
    }

    @Transactional  // 유저의 관심사 등록
    public UserInterest registUserInterest(User user, Interest interest) {
        UserInterest uInter = new UserInterest(user.getUserNo(), interest.getInterestNo());

        uInter = userInterestRepository.save(uInter);

        return uInter;
    }

    @Transactional  // 유저의 관심사 삭제
    public void removeUserInterest(User user, Interest interest) {
        UserInterest userInterest = userInterestRepository
                .findByUserNoAndInterestNo(
                user.getUserNo(),
                interest.getInterestNo()
                );

        userInterestRepository.delete(userInterest);
    }
}
