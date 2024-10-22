package com.polychat.polychatbe.user.command.application.controller;

import com.polychat.polychatbe.common.utils.ApiUtils;
import com.polychat.polychatbe.user.command.application.dto.UserRequestDTO;
import com.polychat.polychatbe.user.command.application.service.UserLoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@Tag(name = "일반 로그인 API", description = "회원 가입, 로그인, 토큰 재발급, 로그아웃 기능을 제공하는 API")
public class UserLoginController {

    private final UserLoginService userLoginService;

    /**
     * 기본 회원 가입
     */
    @Operation(summary = "회원 가입", description = "회원 가입을 처리합니다.")
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody UserRequestDTO.signUpDTO requestDTO) {

        userLoginService.signUp(requestDTO);

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }


//    /**
//     * 기본 로그인
//     */
//    @Operation(summary = "로그인", description = "회원 로그인을 처리하고 인증 토큰을 발급합니다.")
//    @PostMapping("/login")
//    public ResponseEntity<?> login(HttpServletRequest httpServletRequest, @Valid @RequestBody UserRequestDTO.loginDTO requestDTO) {
//
//        UserResponseDTO.authTokenDTO responseDTO = userLoginService.login(httpServletRequest, requestDTO);
//
//        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
//    }
//
//    /**
//     * Access Token 재발급 - Refresh Token 필요
//     */
//    @Operation(summary = "토큰 재발급", description = "Refresh Token을 사용하여 Access Token을 재발급합니다.")
//    @PostMapping("/reissue")
//    public ResponseEntity<?> reissueToken(HttpServletRequest httpServletRequest) {
//
//        UserResponseDTO.authTokenDTO responseDTO = userLoginService.reissueToken(httpServletRequest);
//
//        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
//    }
//
//    /**
//     * 로그아웃 - Refresh Token 필요
//     */
//    @Operation(summary = "로그아웃", description = "Refresh Token을 사용하여 로그아웃을 처리합니다.")
//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(HttpServletRequest httpServletRequest) {
//
//        log.info("로그아웃 시도");
//
//        userLoginService.logout(httpServletRequest);
//
//        return ResponseEntity.ok().body(ApiUtils.success(null));
//    }
}
