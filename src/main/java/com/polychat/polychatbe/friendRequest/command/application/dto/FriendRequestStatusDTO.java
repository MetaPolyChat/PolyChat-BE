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
public class FriendRequestStatusDTO {

    @NotBlank(message = "친구 신청 정보를 확인해주세요.")
    @Positive
    private Integer friendRequestId;

    @NotBlank(message = "친구 신청 상태를 확인해주세요.")
    private RequestStatus status;

}
