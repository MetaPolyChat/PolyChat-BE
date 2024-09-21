package com.polychat.polychatbe.user.command.application.controller;


import com.polychat.polychatbe.login.utils.ApiUtils;
import com.polychat.polychatbe.user.command.application.dto.UserRequestDTO;
import com.polychat.polychatbe.user.command.application.service.UserSocialLoginService;
import com.polychat.polychatbe.user.command.application.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
@Tag(name = "구글 로그인 API", description = "구글 로그인 및 회원가입 기능을 제공하는 API")
public class UserSocialLoginController {

    private final UserSocialLoginService userSocialLoginService;

    // @Value 어노테이션을 사용하여 application.yml 에서 client-id 값을 불러옵니다.
    @Value("${spring.security.oauth2.client.registration.google.clientId}")
    private String googleClientId;

    @Value("${spring.security.oauth2.client.registration.google.redirect_uri}")
    private String googleRedirectUri;

    /**
     * 구글 로그인 리디렉션
     */
    @GetMapping("/google/redirect")
    public void redirectToGoogle(HttpServletResponse response) throws IOException {
        String redirectUri = "https://accounts.google.com/o/oauth2/v2/auth?"
                + "client_id=" + googleClientId
                + "&redirect_uri=" + googleRedirectUri
                + "&response_type=code"
                + "&scope=openid%20email"; // 필요한 스코프
        response.sendRedirect(redirectUri);
    }

    /**
     * 구글 로그인 후 회원가입 여부 확인 및 처리
     * @param code 구글 서버가 보낸 인증 코드
     */
    @GetMapping("/google/login")
    public void googleLogin(@RequestParam(name = "code") String code, HttpServletResponse response) throws IOException {
        System.out.println("Google login started with code: " + code);

        // 구글 인증 코드 수신 후 로그인 처리
        UserResponseDTO.authTokenDTO responseDTO = userSocialLoginService.googleLogin(code);
        if (responseDTO == null) {
            System.out.println("회원가입 페이지로 리다이렉트 합니다.");
            response.sendRedirect("/signup"); // 회원가입 페이지로 리다이렉트
            return;
        }

        // JWT 토큰을 클라이언트에게 반환 (JSON 응답)
        System.out.println("토큰을 클라이언트에게 반환합니다.");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.getWriter().write(ApiUtils.success(responseDTO).toString());

    }

    /**
     * 추가 정보 입력 후 회원가입 처리
     */
    @PostMapping("/google/signup")
    public ResponseEntity<?> googleSignUp(@RequestBody UserRequestDTO.signUpDTO request) {
        // 클라이언트로부터 추가 정보 수신 후 회원가입 처리
//        UserResponseDTO.authTokenDTO responseDTO = userSocialLoginService.googleSignUp(request);
//
//        // JWT 토큰을 JSON 형식으로 클라이언트에 반환
//        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));

        return null;
    }

}
