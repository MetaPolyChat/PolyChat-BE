package com.polychat.polychatbe.user.command.application.controller;

import com.polychat.polychatbe.user.command.application.dto.UserRequestDTO;
import com.polychat.polychatbe.user.command.application.dto.UserResponseDTO;
import com.polychat.polychatbe.user.command.application.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController("/user")
public class UserApiController {

    private final UserInfoService userService;

    /**
     * 시스템용 정보 호출
     */
    @Operation(summary = "시스템용 유저 info")
    @GetMapping("/info")
    public ResponseEntity<?> findUserInfo(@RequestParam Long userId) {
        UserResponseDTO.UserInfoDTO response = userService.findUserById(userId);
        return ResponseEntity.ok(response);
    }

    /**
     * 내 프로필 조회 (interest 포함)
     */
    @Operation(summary = "내 프로필 (관심사 포함)")
    @GetMapping("/my-profile")
    public ResponseEntity<?> getMyProfile(@RequestParam Long userId) {
        UserResponseDTO.UserMyProfileDTO profileDTO = userService.getMyProfile(userId);
        return ResponseEntity.ok(profileDTO);
    }


    /**
     * 다른 사람 프로필 조회? (interest 포함)
     */
    @Operation(summary = "다른 유저 프로필 (관심사 포함)")
    @GetMapping("/profile")
    public ResponseEntity<?> findUserProfile(@RequestParam String planet) {
        UserResponseDTO.UserProfileDTO profileDTO = userService.findUserProfile(planet);
        return ResponseEntity.ok(profileDTO);
    }


    /**
     * 간단 조회
     */
    @Operation(summary = "유저 닉네임 조회")
    @GetMapping("/nickName")
    public ResponseEntity<?> findUserNickName(@RequestParam Long userId) {
        UserResponseDTO.nickNameDTO response = userService.findUserName(userId);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "유저 존재 여부")
    @GetMapping("/exist")
    public ResponseEntity<?> findUserExist(@RequestParam Long userId) {
        return ResponseEntity.ok(userService.findUserExist(userId));
    }

    /**
     * 회원 정보 수정
     * */
    @Operation(summary = "유저 닉네임 변경")
    @PutMapping("/update/nickname")
    public ResponseEntity<?> updateUserNickname(@RequestBody UserRequestDTO.UpdateNameDTO updateNameDTO) {
        userService.updateUserNickname(updateNameDTO);
        return ResponseEntity.ok().build();
    }

}
