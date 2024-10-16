package com.polychat.polychatbe.user.command.domain.service;

import com.polychat.polychatbe.user.command.domain.model.Authority;
import com.polychat.polychatbe.user.command.domain.model.User;
import com.polychat.polychatbe.user.command.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AuthorityCheckService {

    private UserRepository userRepository;

    public AuthorityCheckService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 관리자 권한인지 테스트
    public boolean hasAccountModify(long userId){
        User user = userRepository.findById(userId).orElseThrow(
                ()->new NoSuchElementException("존재하지 않는 유저입니다.")
        );

        return user.getAuthority()== Authority.ADMIN;
    }
}
