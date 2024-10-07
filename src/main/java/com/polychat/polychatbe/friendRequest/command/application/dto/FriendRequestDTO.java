package com.polychat.polychatbe.friendRequest.command.application.dto;

import com.polychat.polychatbe.friendRequest.command.domain.model.RequestStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequestDTO {

    @NotBlank(message = "보내는 사람 정보를 확인해주세요.")
    @Positive
    private long senderId;

    @NotBlank(message = "받는 사람 정보를 확인해주세요.")
    @Positive
    private long receiverId;

    @NotBlank(message = "친구 신청 상태를 확인해주세요.")
    private RequestStatus status;

}
