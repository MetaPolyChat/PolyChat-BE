package com.polychat.polychatbe.user.command.application.controller;


import com.polychat.polychatbe.login.utils.ApiUtils;
import com.polychat.polychatbe.user.command.application.service.UserSocialLoginService;
import com.polychat.polychatbe.user.command.application.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
@Tag(name = "구글 로그인 API", description = "구글 로그인 및 회원가입 기능을 제공하는 API")
public class UserSocialLoginController {

    private final UserSocialLoginService userSocialLoginService;

    // @Value 어노테이션을 사용하여 application.yml에서 client-id 값을 불러옵니다.
    @Value("${spring.security.oauth2.client.registration.kakao.clientId}")
    private String kakaoClientId;

    @Value("${spring.security.oauth2.client.registration.kakao.redirect_uri}")
    private String kakaoRedirectUri;


    /**
     카카오 로그인 리디렉션
     */
    @GetMapping("/kakao/redirect")
    public void redirectToKakao(HttpServletResponse response) throws IOException {
        // 카카오 로그인 페이지로 리디렉션
        // 언리얼에서 https://server주소/api/auth/kakao/redirect
        String redirectUri = "https://kauth.kakao.com/oauth/authorize?client_id=" + kakaoClientId + "&redirect_uri=" + kakaoRedirectUri + "&response_type=code";
        response.sendRedirect(redirectUri);
    }


    /**
     카카오 로그인
     */
    @GetMapping("/kakao/login")
    public ResponseEntity<?> kakaoLogin(@RequestParam(name = "code") String code) {
        System.out.println(code);

        System.out.println("here");

        // 카카오 인증 코드 수신 후 로그인 처리
        UserResponseDTO.authTokenDTO responseDTO = userSocialLoginService.kakaoLogin(code);

        // JWT 토큰을 JSON 형식으로 클라이언트에 반환
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

}
