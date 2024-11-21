package com.polychat.polychatbe.user.command.application.controller;

import com.polychat.polychatbe.user.command.application.dto.UserResponseDTO;
import com.polychat.polychatbe.user.command.application.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/user")
public class UserApiController {

    private final UserInfoService userService;

    /**
     * 시스템용 정보 호출
     */
    @GetMapping("/info")
    public ResponseEntity<?> findUserInfo(Long userId) {
        UserResponseDTO.UserInfoDTO response = userService.findUserById(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/nickName")
    public ResponseEntity<?> findUserNickName(Long userId) {
        UserResponseDTO.nickNameDTO response = userService.findUserName(userId);
        return ResponseEntity.ok(response);
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
