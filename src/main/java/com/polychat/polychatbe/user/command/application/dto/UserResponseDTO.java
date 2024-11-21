package com.polychat.polychatbe.user.command.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.polychat.polychatbe.user.command.domain.model.Authority;
import com.polychat.polychatbe.user.command.domain.model.LoginType;
import com.polychat.polychatbe.user.command.domain.model.Status;

import java.time.LocalDateTime;
import java.util.List;

public class UserResponseDTO {

//    /** 토큰 발급
//     * @param grantType
//     * @param accessToken
//     * @param accessTokenValidTime
//     * @param refreshToken
//     * @param refreshTokenValidTime
//     */
//
//    public record authTokenDTO(
//            String grantType,
//            String accessToken,
//            Long accessTokenValidTime,
//            String refreshToken,
//            Long refreshTokenValidTime
//    ) {
//    }

    /**
     * 로그인을 위한 처리
     * */
    public record authDTO(
            Long userId,
            boolean isSignIn
    ){
    }

    /** 구글 OAuth2 프로필
     * @param email
     */
    public record GoogleEmailDTO(
            String email,        // 사용자의 이메일 주소
            boolean email_verified // 이메일이 검증되었는지 여부
    ) {
    }

    public record GoogleTokenDTO(
            @JsonProperty("access_token")
            String accessToken,
            @JsonProperty("expires_in")
            int expiresIn,
            @JsonProperty("scope")
            String scope,
            @JsonProperty("token_type")
            String tokenType,
            @JsonProperty("id_token")
            String idToken,
            @JsonProperty("refresh_token")
            String refreshToken
    ) {
    }


    /**
     * 유저 데이터 반환
     * */
    public record UserInfoDTO(
            Long userId,
            String email,
            String userName,
            LoginType loginType,
            String planet
    ){}

    public record nickNameDTO(
            String userName
    ){}

    public record UserMyProfileDTO(
            String email,
            String userName,
            String planet,
            LocalDateTime createdAt,
            List<String> interests
    ){}

    public record UserProfileDTO(
            String userName,
            String planet,
            List<String> interests
    ){}


}
