package com.polychat.polychatbe.admin.command.application.controller;

import com.polychat.polychatbe.blockList.command.application.dto.BlockUserDTO;
import com.polychat.polychatbe.blockList.command.application.service.BlockListAppService;
import com.polychat.polychatbe.blockList.command.domain.model.BlockList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class adminPageController {

    BlockListAppService blockListAppService;

    public adminPageController(BlockListAppService blockListAppService) {
        this.blockListAppService = blockListAppService;
    }


    @GetMapping("/admin")
    public String adminPage() {
        return "adminDashboard";
    }

    // block, release, find(count>5)
    @Operation(summary = "전체 블록 리스트", description = "블록 리스트 전체를 불러옵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "블록리스트를 모두 가져왔습니다."),
            @ApiResponse(responseCode = "500", description = "서버 에러")
    })
    @GetMapping(value = "/admin/blockuser", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<BlockUserDTO>> adminBlockUser() {
        List<BlockUserDTO> blockLists = blockListAppService.getAllBlockLists();
        System.out.println(blockLists);
        return ResponseEntity.ok(blockLists);
    }

    //find, update(count ++)
    @GetMapping("/admin/logincount")
    public String adminLoginCount() {
        return "Admin Login Count";
    }

    //find, complete, reply( if(find.moreThanOne) -> update)
    @GetMapping("/admin/question")
    public String adminQuestion() {
        return "Admin Question";
    }

    //create
    @GetMapping("/user/question")
    public String userQuestion() {
        return "Admin Question";
    }

}
