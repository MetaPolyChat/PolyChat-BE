package com.polychat.polychatbe.user.command.application.service;


import com.polychat.polychatbe.login.property.KakaoProviderProperties;
import com.polychat.polychatbe.login.property.KakaoRegistrationProperties;
import com.polychat.polychatbe.user.command.application.dto.UserResponseDTO;
import com.polychat.polychatbe.login.error.ApplicationException;
import com.polychat.polychatbe.login.error.ErrorCode;
import com.polychat.polychatbe.login.jwt.JWTTokenProvider;
import com.polychat.polychatbe.user.command.domain.model.Authority;
import com.polychat.polychatbe.user.command.domain.model.LoginType;
import com.polychat.polychatbe.user.command.domain.model.User;
import com.polychat.polychatbe.user.command.domain.repository.UserRepository;
import com.polychat.polychatbe.user.command.domain.service.UserRandomGenerateService;
import com.polychat.polychatbe.user.command.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.UUID;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserSocialLoginService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final UserRandomGenerateService userRandomGenerateService;

    private final PasswordEncoder passwordEncoder;
    private final JWTTokenProvider jwtTokenProvider;

    private final RestTemplate restTemplate = new RestTemplate();
    private final KakaoProviderProperties kakaoProviderProperties;
    private final KakaoRegistrationProperties kakaoRegistrationProperties;


    /**
        구글 로그인
     */
    @Transactional
    public UserResponseDTO.authTokenDTO kakaoLogin(String code) {
        System.out.println("Google Login 시작");

        // 카카오로부터 액세스 토큰 발급
        String accessToken = generateAccessToken(code);

        // 액세스 토큰을 사용하여 카카오 사용자 프로필 가져오기
        UserResponseDTO.KakaoInfoDTO profile = getKakaoProfile(accessToken);
        System.out.println("프로필 " + profile);

        // 사용자가 이미 존재하는지 확인하고 없으면 새로운 사용자 생성
        User user = userService.findUserByEmail(profile.kakaoAccount().email())
                .orElseGet(() -> googleSignUp(profile));

        // JWT 토큰 생성 및 반환
        return getSocialAuthTokenDTO(user);
    }

    /**
     카카오 액세스 토큰 받기
     */
    private String generateAccessToken(String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", kakaoRegistrationProperties.getAuthorizationGrantType());
        params.add("client_id", kakaoRegistrationProperties.getClientId());
        params.add("redirect_uri", kakaoRegistrationProperties.getRedirectUri());
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);
        ResponseEntity<UserResponseDTO.KakaoTokenDTO> response = restTemplate.postForEntity(
                kakaoProviderProperties.getTokenUri(),
                httpEntity,
                UserResponseDTO.KakaoTokenDTO.class
        );

        if(!response.getStatusCode().is2xxSuccessful()) {
            throw new ApplicationException(ErrorCode.FAILED_GET_ACCESS_TOKEN);
        }

        return response.getBody().accessToken();
    }

    /**
     카카오회원 프로필 정보 가져오기
     */
    private UserResponseDTO.KakaoInfoDTO getKakaoProfile(String accessToken) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBearerAuth(accessToken);

        ResponseEntity<UserResponseDTO.KakaoInfoDTO> response = restTemplate.postForEntity(
                kakaoProviderProperties.getUserInfoUri(),
                new HttpEntity<>(headers),
                UserResponseDTO.KakaoInfoDTO.class
        );

        if(!response.getStatusCode().is2xxSuccessful()) {
            throw new ApplicationException(ErrorCode.FAILED_GET_KAKAO_PROFILE);
        }

        return response.getBody();
    }

    /**
     구글 회원가입
     */
    protected User googleSignUp(UserResponseDTO.KakaoInfoDTO profile) {
        log.info("구글 회원 생성 : " + profile.kakaoAccount().email());

        User user = User.builder()
                .userId(userRandomGenerateService.generateGoogleUserID())
                .userName(profile.properties().nickname())
                .password(passwordEncoder.encode(UUID.randomUUID().toString()))
                .loginType(LoginType.GOOGLE)
                .authority(Authority.USER)
                .email(profile.kakaoAccount().email())
                .planet(userRandomGenerateService.generatePlanetCode())
                .build();

        userRepository.save(user);

        return user;
    }

    /**
     소셜 로그인 회원 토큰 생성
     */
    private UserResponseDTO.authTokenDTO getSocialAuthTokenDTO(User user) {

        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getEmail(), "",
                Collections.singletonList(new SimpleGrantedAuthority(user.getAuthority().toString())));

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        return jwtTokenProvider.generateToken(authentication);
    }
}
