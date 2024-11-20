package com.polychat.polychatbe.user.command.application.service;

import com.polychat.polychatbe.common.error.ApplicationException;
import com.polychat.polychatbe.common.error.ErrorCode;
import com.polychat.polychatbe.user.command.application.dto.UserRequestDTO;
import com.polychat.polychatbe.user.command.application.dto.UserResponseDTO;
import com.polychat.polychatbe.user.command.domain.model.Authority;
import com.polychat.polychatbe.user.command.domain.model.User;
import com.polychat.polychatbe.user.command.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Transactional(readOnly = false)
@RequiredArgsConstructor
@Service
public class UserLoginService {

    public final UserService userService;
    //    private final UserRepository userRepository;
//    private final RefreshTokenRepository refreshTokenRepository;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
//    private final JWTTokenProvider jwtTokenProvider;

    /*
        기본 회원 가입
     */
    @Transactional
    public boolean signUp(UserRequestDTO.signUpDTO requestDTO) {


        // 비밀번호 확인
        checkValidPassword(requestDTO.password(), passwordEncoder.encode(requestDTO.password()));


        // 회원 저장
        return userService.saveUser(requestDTO);

    }

    @Transactional
    public UserResponseDTO.UserInfoDTO findUserById(Long id) {
        User user = userService.findUserById(id);
        if (user == null) {
            throw new ApplicationException(ErrorCode.NO_SUCH_USER);
        }

        if (Authority.ADMIN.equals(user.getAuthority())){
            throw new ApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        } else {
            return new UserResponseDTO.UserInfoDTO(
                    user.getUserId(),
                    user.getEmail(),
                    user.getUserName(),
                    user.getLoginType(),
                    user.getPlanet()
            );
        }
    }

    /*
        기본 로그인
     */
//    public UserResponseDTO.authTokenDTO login(HttpServletRequest httpServletRequest, UserRequestDTO.loginDTO requestDTO) {
//
//        // 1. 이메일 확인
//        User member = findMemberByEmail(requestDTO.email())
//                .orElseThrow(() -> new ApplicationException(ErrorCode.EMPTY_EMAIL_MEMBER));
//
//        // 2. 비밀번호 확인
//        checkValidPassword(requestDTO.password(), member.getPassword());
//
//        return getAuthTokenDTO(requestDTO.email(), requestDTO.password(), httpServletRequest);
//    }

    // 비밀번호 확인
    private void checkValidPassword(String rawPassword, String encodedPassword) {

        log.info("{} {}", rawPassword, encodedPassword);

        if(!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new ApplicationException(ErrorCode.INVALID_PASSWORD);
        }
    }

    protected Optional<User> findMemberByEmail(String email) {
        log.info("회원 확인 : {}", email);

        return userService.findUserByEmail(email);
    }



    // 토큰 발급
//    protected UserResponseDTO.authTokenDTO getAuthTokenDTO(String email, String password, HttpServletRequest httpServletRequest) {
//
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
//                = new UsernamePasswordAuthenticationToken(email, password);
//        AuthenticationManager manager = authenticationManagerBuilder.getObject();
//        Authentication authentication = manager.authenticate(usernamePasswordAuthenticationToken);
//
//        UserResponseDTO.authTokenDTO authTokenDTO = jwtTokenProvider.generateToken(authentication);
//
//        // 단일 권한 추출 (가정: 단일 권한만 부여됨)
//        Authority authority = Authority.USER; // 기본값
//        if (!authentication.getAuthorities().isEmpty()) {
//            authority = Authority.valueOf(authentication.getAuthorities().iterator().next().getAuthority());
//        }
//
//        refreshTokenRepository.save(RefreshToken.builder()
//                .userName(authentication.getName())
//                .ip(ClientUtils.getClientIp(httpServletRequest))
//                .authorities(authority)
//                .refreshToken(authTokenDTO.refreshToken())
//                .build()
//        );
//
//        return authTokenDTO;
//    }
//
//    // 토큰 재발급
//    public UserResponseDTO.authTokenDTO reissueToken(HttpServletRequest httpServletRequest) {
//
//        // Request Header 에서 JWT Token 추출
//        String token = jwtTokenProvider.resolveToken(httpServletRequest);
//
//        // 토큰 유효성 검사
//        if(token == null || !jwtTokenProvider.validateToken(token)) {
//            throw new ApplicationException(ErrorCode.FAILED_VALIDATE_ACCESS_TOKEN);
//        }
//
//        // type 확인
//        if(!jwtTokenProvider.isRefreshToken(token)) {
//            throw new ApplicationException(ErrorCode.IS_NOT_REFRESH_TOKEN);
//        }
//
//        // RefreshToken
//        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByRefreshToken(token);
//
//        if(refreshToken.isEmpty()) {
//            throw new ApplicationException(ErrorCode.FAILED_GET_RERFRESH_TOKEN);
//        }
//
//        // 최초 로그인한 ip와 같은지 확인
//        String currentIp = ClientUtils.getClientIp(httpServletRequest);
//        if(!currentIp.equals(refreshToken.get().getIp())) {
//            throw new ApplicationException(ErrorCode.DIFFERENT_IP_ADDRESS);
//        }
//
//        // 저장된 RefreshToken 정보를 기반으로 JWT Token 생성
//        UserResponseDTO.authTokenDTO authTokenDTO = jwtTokenProvider.generateToken(
//                String.valueOf(refreshToken.get().getId()), Collections.singletonList(new SimpleGrantedAuthority(refreshToken.get().getAuthorities().name()))
//        );
//
//        // RefreshToken Update
//        refreshTokenRepository.save(RefreshToken.builder()
//                .ip(currentIp) // IP 주소를 업데이트
//                .authorities(refreshToken.get().getAuthorities())
//                .refreshToken(authTokenDTO.refreshToken())
//                .build());
//
//        return authTokenDTO;
//    }
//
//    /*
//        로그아웃
//     */
//    public void logout(HttpServletRequest httpServletRequest) {
//
//        log.info("로그아웃 - Refresh Token 확인");
//
//        String token = jwtTokenProvider.resolveToken(httpServletRequest);
//
//        if(token == null || !jwtTokenProvider.validateToken(token)) {
//            throw new ApplicationException(ErrorCode.FAILED_VALIDATE__REFRESH_TOKEN);
//        }
//
//        // RefreshToken 조회 및 null 체크
//        RefreshToken refreshToken = refreshTokenRepository.findByRefreshToken(token)
//                .orElseThrow(() -> {
//                    log.error("Refresh Token 을 얻을 수 없습니다. 토큰: {}", token);
//                    return new ApplicationException(ErrorCode.FAILED_GET_RERFRESH_TOKEN);
//                });
//
//        refreshTokenRepository.delete(refreshToken);
//        log.info("로그아웃 성공");
//    }
}
