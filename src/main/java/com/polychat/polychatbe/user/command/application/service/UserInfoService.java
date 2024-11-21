package com.polychat.polychatbe.user.command.application.service;

import com.polychat.polychatbe.common.error.ApplicationException;
import com.polychat.polychatbe.common.error.ErrorCode;
import com.polychat.polychatbe.user.command.application.dto.UserResponseDTO;
import com.polychat.polychatbe.user.command.domain.model.Authority;
import com.polychat.polychatbe.user.command.domain.model.User;
import com.polychat.polychatbe.user.command.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserInfoService {

    public final UserService userService;


    public UserResponseDTO.UserInfoDTO findUserById(Long id) {
        User user = userService.findUserById(id);
        if (user == null) {
            throw new ApplicationException(ErrorCode.NO_SUCH_USER);
        }

        if (Authority.ADMIN.equals(user.getAuthority())){
            throw new ApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }

        return new UserResponseDTO.UserInfoDTO(
                user.getUserId(),
                user.getEmail(),
                user.getUserName(),
                user.getLoginType(),
                user.getPlanet()
        );
    }

    public UserResponseDTO.nickNameDTO findUserName(Long id) {
        User user = userService.findUserById(id);
        if (user == null) {
            throw new ApplicationException(ErrorCode.NO_SUCH_USER);
        }

        if (Authority.ADMIN.equals(user.getAuthority())){
            throw new ApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }

        return new UserResponseDTO.nickNameDTO(
                user.getUserName()
        );
    }

}
