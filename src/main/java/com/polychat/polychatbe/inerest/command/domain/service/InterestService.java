package com.polychat.polychatbe.inerest.command.domain.service;

import com.polychat.polychatbe.inerest.command.domain.model.Interest;
import com.polychat.polychatbe.inerest.command.domain.model.UserInterest;
import com.polychat.polychatbe.inerest.command.domain.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InterestService {

    private InterestRepository interestRepository;

    @Autowired
    public InterestService(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }

    @Transactional
    public void registUserInterest(Long userId, Long interestId) {
        UserInterest userInterest = new UserInterest(userId, interestId);
        interestRepository.saveUserInterest(userInterest);
    }

    @Transactional
    public void registInterest(String InterestName) {
        Interest interest = new Interest(InterestName);
        interestRepository.saveInterest(interest);
    }

    public List<Interest> findUserInterestsByUserId(Long userId) {
        return interestRepository.findAllInterestsByUserId(userId);
    }

    public Interest findInterestById(Long interestId) {
        return interestRepository.findInterestById(interestId);
    }
}
