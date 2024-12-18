package com.polychat.polychatbe.user.command.application.controller;


import com.polychat.polychatbe.common.utils.ApiUtils;
import com.polychat.polychatbe.user.command.application.dto.UserRequestDTO;
import com.polychat.polychatbe.user.command.application.service.UserSocialLoginService;
import com.polychat.polychatbe.user.command.application.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
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

    @Value("${nginx.url.backend}")
    private String backendUrl;

    @Value("${nginx.url.react}")
    private String reactUrl;

    /**
     * 구글 로그인 리디렉션
     */
    @GetMapping("/google/redirect")
    public void redirectToGoogle(HttpServletResponse response) throws IOException {
        String redirectUri = googleAuthorizationUri + "?"
                + "client_id=" + googleClientId
                + "&redirect_uri=" + googleRedirectUri
                + "&response_type=code"
                + "&scope=" + scope;
        System.out.println("redirectUri : " + redirectUri);
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

        // 구글 인증 코드 수신 후 로그인 처리
        UserResponseDTO.authDTO authDTO = userSocialLoginService.googleLogin(code);

        if (authDTO.isSignIn()) {
            System.out.println("로그인 : " + authDTO);
            response.sendRedirect(reactUrl + "/unity-build?userId=" + authDTO.userId());
        }else {
            //없으면 회원가입으로
            response.sendRedirect(reactUrl + "/create-account?userId=" + authDTO.userId());
        }

    }


    /**
     * 추가 정보 입력 후 회원가입 처리
     */
    @PostMapping("/google/signup")
    public ResponseEntity<?> googleSignUp(@RequestBody UserRequestDTO.googleSignUpDTO signUpDTO) {
        // 클라이언트로부터 추가 정보 수신 후 회원가입 처리
        System.out.println("회원 가입 시작" + signUpDTO);
        UserResponseDTO.authDTO authDTO = userSocialLoginService.googleSignUp(signUpDTO);
        return ResponseEntity.ok().body(ApiUtils.success(authDTO));
    }

//    /**
//     * 로그인 정보 가져오기
//     */
//    @GetMapping("/google/user/info")
//    public ResponseEntity<?> googleUserInfo(@AuthenticationPrincipal OAuth2User oauth2User) {
//        System.out.println("user info started with name: " + oauth2User.getName());
//        System.out.println(oauth2User);
//        System.out.println(oauth2User.getAttributes());
//        return ResponseEntity.ok().body(ApiUtils.success("good"));
//    }


    /**
     * url 테스트
     * */
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        System.out.println("success");
        return ResponseEntity.ok().body(ApiUtils.success("good"));
    }

}
