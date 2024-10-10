package com.polychat.polychatbe.user.command.application.controller;


import com.polychat.polychatbe.login.utils.ApiUtils;
import com.polychat.polychatbe.user.command.application.dto.UserRequestDTO;
import com.polychat.polychatbe.user.command.application.service.UserSocialLoginService;
import com.polychat.polychatbe.user.command.application.dto.UserResponseDTO;
import com.polychat.polychatbe.user.command.domain.model.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
@Tag(name = "구글 로그인 API", description = "구글 로그인 및 회원가입 기능을 제공하는 API")
public class UserSocialLoginController {

    private final UserSocialLoginService userSocialLoginService;

    // @Value 어노테이션을 사용하여 application.yml 에서 값을 불러옵니다.
    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String googleClientId;

    @Value("${spring.security.oauth2.client.registration.google.scope[0]}")
    private String scope;

    @Value("${spring.security.oauth2.client.registration.google.redirect-uri}")
    private String googleRedirectUri;

    @Value("${spring.security.oauth2.client.provider.google.authorization-uri}")
    private String googleAuthorizationUri;

    /**
     * 구글 로그인 리디렉션
     */
    @GetMapping("/google/redirect")
    public void redirectToGoogle(HttpServletResponse response) throws IOException {
        System.out.println("redirectToGoogle");
        String redirectUri = googleAuthorizationUri + "?"
                + "client_id=" + googleClientId
                + "&redirect_uri=" + googleRedirectUri
                + "&response_type=code"
                + "&scope=" + scope;
        response.sendRedirect(redirectUri);
    }

    /**
     * 구글 로그인 후 회원가입 여부 확인 및 처리
     * @param code 구글 서버가 보낸 인증 코드
     */
    @GetMapping("/google/login")
    public void  googleLogin(HttpServletResponse response, HttpServletRequest request, @RequestParam(name = "code") String code) throws IOException {
        System.out.println("Google login started with code: " + code);
        System.out.println("Current Url : " + request.getRequestURL());
//        String redirectUrl = request.getRequestURL()
//                .substring(0,request.getRequestURL().toString().lastIndexOf("/"))
//                + "/signup";
//        System.out.println("redirectUrl: " + redirectUrl);

        // 구글 인증 코드 수신 후 로그인 처리
        UserResponseDTO.authDTO authDTO = userSocialLoginService.googleLogin(code);

        //없으면 회원가입으로
        if (authDTO == null) {
            response.sendRedirect("http://localhost:3000/sign");
//            return ResponseEntity.status(HttpStatus.ACCEPTED).body("go to sign in page");
        }

        System.out.println("로그인 : " + authDTO);
//        return ResponseEntity.status(HttpStatus.OK).body(authDTO);
        response.sendRedirect("http://localhost:3000/public/Unity_WebGL.html"); //확정 아님


    }


    /**
     * 추가 정보 입력 후 회원가입 처리
     */
    @PostMapping("/google/signup")
    public ResponseEntity<?> googleSignUp(@RequestBody UserRequestDTO.signUpDTO request) {
        System.out.println("회원 가입 시작");
        // 클라이언트로부터 추가 정보 수신 후 회원가입 처리
        UserResponseDTO.authDTO authDTO = userSocialLoginService.googleSignUp(request);

        return ResponseEntity.ok().body(ApiUtils.success(authDTO));

    }

    /**
     * 로그인 정보 가져오기
     */
    @GetMapping("/google/user/info")
    public ResponseEntity<?> googleUserInfo(@AuthenticationPrincipal OAuth2User oauth2User) {
        System.out.println("user info started with name: " + oauth2User.getName());
        System.out.println(oauth2User);
        System.out.println(oauth2User.getAttributes());
        return ResponseEntity.ok().body(ApiUtils.success("good"));
    }



}
