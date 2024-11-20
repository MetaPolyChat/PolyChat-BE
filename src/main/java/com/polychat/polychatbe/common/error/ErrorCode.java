package com.polychat.polychatbe.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "METARO-000", "Internal server error"),
    SAME_EMAIL(HttpStatus.CONFLICT, "USER-002", "이미 가입된 이메일입니다."),
    INVALID_PASSWORD(HttpStatus.CONFLICT, "USER-004", "비밀번호가 유효하지 않습니다."),
    NO_SUCH_USER(HttpStatus.NOT_FOUND, "USER-008", "해당 유저는 존재하지 않습니다."),
    FAILED_GET_ACCESS_TOKEN(HttpStatus.EXPECTATION_FAILED, "TOKEN-003", "Access Token 을 가져오는데 실패했습니다."),
    FAILED_GET_GOOGLE_PROFILE(HttpStatus.EXPECTATION_FAILED, "SOCIAL-001", "Google 유저 프로필을 가져오는데 실패했습니다."),
    ANONYMOUS_USER(HttpStatus.UNAUTHORIZED, "AUTH-004", "익명의 유저가 접근하였습니다."),
    ;

    private HttpStatus status;
    private String errorCode;
    private String message;
}
