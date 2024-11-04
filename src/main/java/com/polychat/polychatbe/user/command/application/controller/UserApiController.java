package com.polychat.polychatbe.user.command.application.controller;

import com.polychat.polychatbe.user.command.application.dto.UserResponseDTO;
import com.polychat.polychatbe.user.command.application.service.UserLoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserApiController {

    private final UserLoginService userLoginService;

    public UserApiController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    /**
     * 시스템용 정보 호출
     */
    @GetMapping("/info")
    public UserResponseDTO.UserInfoDTO findUserInfo(Long userId) {
        return userLoginService.findUserById(userId);
    }

    /**
     * 내 프로필 조회 (interest 포함)
     */


    /**
     * 다른 사람 프로필 조회? (interest 포함)
     */


    /**
     * 간단 조회
     */

}
