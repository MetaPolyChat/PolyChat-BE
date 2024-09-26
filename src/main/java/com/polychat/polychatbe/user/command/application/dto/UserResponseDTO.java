package com.polychat.polychatbe.user.command.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public record authDTO(
            Long userId,
            String userEmail
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


//
//    public record GoogleProfileDTO(
//            String sub,         // 구글 사용자 고유 ID
//            String name,        // 사용자의 이름
//            String given_name,  // 이름 (성 제외)
//            String family_name, // 성
//            String email,       // 이메일 주소
//            boolean email_verified, // 이메일 인증 여부
//            String picture,     // 프로필 사진 URL
//            String locale       // 사용자 언어 및 국가 정보
//    ) {
//    }

}
