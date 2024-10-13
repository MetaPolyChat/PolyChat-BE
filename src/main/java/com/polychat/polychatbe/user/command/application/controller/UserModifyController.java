package com.polychat.polychatbe.user.command.application.controller;

import com.polychat.polychatbe.user.command.application.dto.UserModifyDTO;
import com.polychat.polychatbe.user.command.application.service.UserModifyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@Tag(name = "계정 상태 변경 API", description = "권한, 탈퇴 상태를 수정하는 API")

public class UserModifyController {

    private final UserModifyService userModifyService;

    @Operation(summary = "계정 정보 변경", description = "계정 정보를 변경합니다.")
    @PutMapping("/account/{id}")
    public void modifyUserAccountStatus(@PathVariable long changedUserId, UserModifyDTO userModifyInfo){
        userModifyService.modifyUserAccountStatus(changedUserId, userModifyInfo);
    }

    @Operation(summary = "회원 탈퇴", description = "지정한 유저를 회원탈퇴 처리합니다.")
    @DeleteMapping("/{id}")
    public void withdrawUser(@PathVariable long id, Long modifierId){
        if (modifierId == null){
            userModifyService.withdraw(id);
        } else{
            userModifyService.withdrawOtherUser(id, modifierId);
        }
    }

    @Operation(summary = "권한 수정", description = "지정한 유저의 권한을 수정합니다.")
    @PutMapping("/authority/{id}")
    public void changeAuthority(@PathVariable long id, long modifierId){
        userModifyService.changeAuthority(id, modifierId);
    }
}
