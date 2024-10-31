package com.polychat.polychatbe.user.command.application.service;


import com.polychat.polychatbe.login.property.GoogleProviderProperties;
import com.polychat.polychatbe.login.property.GoogleRegistrationProperties;
import com.polychat.polychatbe.user.command.application.dto.UserRequestDTO;
import com.polychat.polychatbe.user.command.application.dto.UserResponseDTO;
import com.polychat.polychatbe.common.error.ApplicationException;
import com.polychat.polychatbe.common.error.ErrorCode;
import com.polychat.polychatbe.user.command.domain.model.Authority;
import com.polychat.polychatbe.user.command.domain.model.LoginType;
import com.polychat.polychatbe.user.command.domain.model.Status;
import com.polychat.polychatbe.user.command.domain.model.User;
import com.polychat.polychatbe.user.command.domain.service.UserRandomGenerateService;
import com.polychat.polychatbe.user.command.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserSocialLoginService {

    private final UserService userService;
    private final UserRandomGenerateService userRandomGenerateService;

    private final RestTemplate restTemplate = new RestTemplate();
    private final GoogleProviderProperties googleProviderProperties;
    private final GoogleRegistrationProperties googleRegistrationProperties;


    /**
        구글 로그인
     */
    @Transactional
    public UserResponseDTO.authDTO googleLogin(String code) {
        System.out.println("Google Login 시작");

        // 구글로부터 액세스 토큰 발급
        String accessToken = generateAccessToken(code);

        // 액세스 토큰을 사용하여 이메일 가져오기
        UserResponseDTO.GoogleEmailDTO emailDTO = getGoogleProfile(accessToken);
        System.out.println("구글 인증 : " + emailDTO);

        // 사용자가 이미 존재하는지 확인
        User user = userService.findUserByEmail(emailDTO.email())
                .orElse(null);
        //없으면 임시 코드 리턴
        if (user == null) {
            return this.signUpTemporary(emailDTO);
        }
        //있으면 임시 회원인지 체크
        if (Status.BEFORE_SIGNUP.equals(user.getStatus())) {
            User tempUser =  userService.findUserByEmail(emailDTO.email()).orElse(null);
            if (tempUser == null) {
                throw new ApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
            }
            //임시 회원이면 코드 리턴
            return new UserResponseDTO.authDTO(tempUser.getUserId(), false);
        }

        // DTO 생성 및 반환
        return new UserResponseDTO.authDTO(user.getUserId(), true);

    }

    /**
     구글 액세스 토큰 받기
     */
    private String generateAccessToken(String code) {
        System.out.println("구글 액세스 토큰 받기");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> httpEntity = getMultiValueMapHttpEntity(code, headers);
        ResponseEntity<UserResponseDTO.GoogleTokenDTO> response = restTemplate.postForEntity(
                googleProviderProperties.getTokenUri(),
                httpEntity,
                UserResponseDTO.GoogleTokenDTO.class
        );

        if (response.getBody() == null || !response.getStatusCode().is2xxSuccessful()) {
            throw new ApplicationException(ErrorCode.FAILED_GET_ACCESS_TOKEN);
        }

        return response.getBody().accessToken();
    }

    private HttpEntity<MultiValueMap<String, String>> getMultiValueMapHttpEntity(String code, HttpHeaders headers) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", googleRegistrationProperties.getClientId());
        params.add("client_secret", googleRegistrationProperties.getClientSecret());
        params.add("redirect_uri", googleRegistrationProperties.getRedirectUri());
        params.add("code", code);

        return new HttpEntity<>(params, headers);
    }


    /**
     구글 회원 이메일 정보 가져오기
     */
    private UserResponseDTO.GoogleEmailDTO getGoogleProfile(String accessToken) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<UserResponseDTO.GoogleEmailDTO> response = restTemplate.exchange(
                "https://openidconnect.googleapis.com/v1/userinfo",
                HttpMethod.GET,
                entity,
                UserResponseDTO.GoogleEmailDTO.class
        );

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new ApplicationException(ErrorCode.FAILED_GET_GOOGLE_PROFILE);
        }

        System.out.println(response.getBody());

        return response.getBody();
    }




    @Transactional
    public UserResponseDTO.authDTO signUpTemporary(UserResponseDTO.GoogleEmailDTO emailDTO) {
        log.info("임시 회원 생성 : {}", emailDTO.email());

        User user = User.builder()
                .email(emailDTO.email())
                .userName(userRandomGenerateService.generateGoogleTempUserName())
                .password(UUID.randomUUID().toString())
                .loginType(LoginType.GOOGLE)
                .authority(Authority.USER)
                .status(Status.BEFORE_SIGNUP)
                .planet("Temp")
                .build();

        userService.saveUser(user);
        User created = userService.findUserByEmail(emailDTO.email()).orElse(null);
        if (created == null) {
            throw new ApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
        return new UserResponseDTO.authDTO(
                created.getUserId(),
                false
        );
    }





    /**
     구글 회원가입
     */
    @Transactional
    @Nullable
    public UserResponseDTO.authDTO googleSignUp(UserRequestDTO.googleSignUpDTO signUpDTO) {
        log.info("signUpDTO : {}", signUpDTO);
        log.info("구글 회원 생성 : {}", signUpDTO.userId());
        User user = userService.findUserById(signUpDTO.userId());
        if (user == null) {
            throw new ApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }

        if (Status.BEFORE_SIGNUP.equals(user.getStatus())) {
            this.signUpNewUserWithID(user, signUpDTO);
            return new UserResponseDTO.authDTO(user.getUserId(), true);
        }

        throw new ApplicationException(ErrorCode.SAME_EMAIL);
    }


    public void signUpNewUserWithID(User user, UserRequestDTO.googleSignUpDTO signUpDTO) {
        user = new User(
                user.getUserId(),
                user.getEmail(),
                signUpDTO.nickname(),
                UUID.randomUUID().toString(),
                LoginType.GOOGLE,
                Authority.USER,
                Status.ACTIVATED,
                userRandomGenerateService.generatePlanetCode(),
                LocalDateTime.now()
        );

        userService.saveUser(user);
    }
}
