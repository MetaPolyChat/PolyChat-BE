package com.polychat.polychatbe.blockList.command.application.controller;

import com.polychat.polychatbe.blockList.command.application.dto.BlockUserDTO;
import com.polychat.polychatbe.blockList.command.application.service.BlockListAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlockListController {

    BlockListAppService blockListAppService;

    public BlockListController(BlockListAppService blockListAppService) {
        this.blockListAppService = blockListAppService;
    }



    @Operation(summary = "유저 블락", description = "유저를 블락합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저를 블락하였습니다."),
            @ApiResponse(responseCode = "400", description = "이미 블락된 유저"),
            @ApiResponse(responseCode = "500", description = "서버 에러")
    })
    @PostMapping(value = "/api/block", produces = "application/json; charset=UTF-8")
    //Todo : 로그인 유저 id 받기 -> currentUser
    public ResponseEntity<String> blockUser(@RequestBody Long blockedUserId, Long currentUser) {
        if (blockedUserId.longValue() == currentUser.longValue()) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("뜨거운 티 맛좀 볼래?");
        }

        try {
            blockListAppService.blockUser(currentUser, blockedUserId);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.ok("Blocked user: " + blockedUserId);
    }


    @Operation(summary = "유저 블락 해제", description = "유저를 블락해제 합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저를 블락해제 하였습니다."),
            @ApiResponse(responseCode = "204", description = "블락 되지 않은 유저"),
            @ApiResponse(responseCode = "500", description = "서버 에러")
    })
    @PostMapping(value = "/api/unblock", produces = "application/json; charset=UTF-8")
    //Todo : 로그인 유저 id 받기 -> currentUser
    public ResponseEntity<String> unblockUser(@RequestBody Long blockedUserId, Long currentUser) {
        BlockUserDTO blockUserDTO =  blockListAppService.getBlockById(currentUser, blockedUserId);
        if (blockUserDTO == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("블락 되지 않은 유저");
        }
        try {
            blockListAppService.unblockUser(currentUser, blockedUserId);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Unblocked user: " + blockedUserId);
    }


    @Operation(summary = "모든 블락 리스트 호출", description = "관리자 대쉬보드용 리스트 호출")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 불러왔습니다.")
    })
    @GetMapping(value = "/admin/blocklist", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<BlockUserDTO>> blockListAdmin() {
        List<BlockUserDTO> blockList = blockListAppService.getAllBlockLists();
        return ResponseEntity.status(HttpStatus.OK).body(blockList);
    }
}
