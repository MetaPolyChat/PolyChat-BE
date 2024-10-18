package com.polychat.polychatbe.user.command.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserRequestDTO {

    /** 기본 회원 가입
     * @param name
     * @param email
     * @param password
     */
    public record signUpDTO(
            @NotBlank(message = "닉네임을 입력해 주세요.")
            String name,
            @NotBlank(message = "이메일을 입력해주세요.")
            String email,
            @NotBlank(message = "비밀번호를 입력해주세요")
            @Pattern(regexp = "^(?=.*\\d).{6,}$", message = "비밀번호는 최소 6자 이상이어야 하며, 숫자를 포함해야 합니다.")
            String password

    ) {
    }

    /** 기본 로그인
     * @param email
     * @param password
     */
    public record loginDTO(
            @NotBlank(message = "ID를 입력해 주세요.")
            String email,
            String password
    ) {
    }

    /** 기본 로그인
     * @param email
     * @param name
     */
    public record userDataDTO(
            @NotBlank(message = "ID를 입력해 주세요.")
            String email,
            String name
    ) {
    }

    /** 구글 로그인
     *
     * */
    public record googleSignUpDTO(
            Long userId,
            String nickname
    ){}


}
