package com.polychat.polychatbe.user.command.application.service;

import com.polychat.polychatbe.user.command.application.dto.UserModifyDTO;
import com.polychat.polychatbe.user.command.domain.model.Authority;
import com.polychat.polychatbe.user.command.domain.model.Status;
import com.polychat.polychatbe.user.command.domain.model.User;
import com.polychat.polychatbe.user.command.domain.repository.UserRepository;
import com.polychat.polychatbe.user.command.domain.service.AuthorityCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserModifyService {

    private final UserRepository userRepository;
    private final AuthorityCheckService authorityCheckService;

    @Transactional
    public void modifyUserAccountStatus(long changedUserId, UserModifyDTO userModifyInfo){

        User user = userRepository.findById(changedUserId).orElseThrow(
                ()-> new NoSuchElementException("해당 유저를 찾을 수 없습니다.")
        );

        if (authorityCheckService.hasAccountModify(userModifyInfo.getModifierId())){
            throw new IllegalArgumentException("계정 정보를 수정할 권한이 존재하지 않습니다.");
        }

        if (userModifyInfo.getStatus()!=null){
            user.updateStatus(userModifyInfo.getStatus());
        }

        if (userModifyInfo.getAuthority()!=null){
            user.updateAuthority(userModifyInfo.getAuthority());
        }
    }

    public void withdraw(long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new NoSuchElementException("해당 유저를 찾을 수 없습니다.")
        );

        if(user.getStatus() == Status.DEACTIVATED){
            throw new IllegalStateException("이미 탈퇴된 회원입니다.");
        }

        user.updateStatus(Status.DEACTIVATED);

    }

    public void withdrawOtherUser(long userId, long changerId) {
        if (authorityCheckService.hasAccountModify(changerId)){
            throw new IllegalArgumentException("계정 정보를 수정할 권한이 존재하지 않습니다.");
        }

        withdraw(userId);
    }

    public void changeAuthority(long userId, long changerId) {

        if (authorityCheckService.hasAccountModify(changerId)){
            throw new IllegalArgumentException("계정 정보를 수정할 권한이 존재하지 않습니다.");
        }

        User user = userRepository.findById(userId).orElseThrow(
                ()-> new NoSuchElementException("해당 유저를 찾을 수 없습니다.")
        );

        user.updateAuthority(Authority.USER);


    }
}
