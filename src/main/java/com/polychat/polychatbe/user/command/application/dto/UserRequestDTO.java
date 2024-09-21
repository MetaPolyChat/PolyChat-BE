package com.polychat.polychatbe.user.command.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserRequestDTO {

    /** 기본 회원 가입
     * @param name
     */
    public record signUpDTO(
            @NotBlank(message = "닉네임을 입력해 주세요.")
            String name,
            @NotBlank(message = "이메일을 입력해주세요.")
            String email

    ) {
    }

    /** 기본 로그인
     * @param userId
     * @param password
     */
    public record loginDTO(
            @NotBlank(message = "ID를 입력해 주세요.")
            String userId,
            String password
    ) {
    }
    
}
