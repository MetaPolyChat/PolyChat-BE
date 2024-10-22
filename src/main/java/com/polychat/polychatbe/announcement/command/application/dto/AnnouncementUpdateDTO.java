package com.polychat.polychatbe.announcement.command.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class AnnouncementUpdateDTO {

    @NotBlank(message = "부적절한 접근입니다.")
    private final Long announcementId;

    @NotBlank(message = "부적절한 접근입니다.")
    private final long uploaderId;

    @NotBlank(message = "제목을 입력해주세요.")
    private final String title;

    @NotBlank(message = "내용을 입력해주세요.")
    @Size(min = 10, message = "내용은 10글자 이상 입력해야 합니다.")
    private final String content;

}
