package com.polychat.polychatbe.admin.command.application.controller;

import com.polychat.polychatbe.blockList.command.application.service.BlockListAppService;
import com.polychat.polychatbe.blockList.command.domain.model.BlockList;
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


    @GetMapping(value = "/admin/blockuser", produces = "application/json; charset=UTF-8")// block, release, find(count>5)
    public ResponseEntity adminBlockUser() {
        List<BlockList> blockLists = blockListAppService.getAllBlockLists();
        System.out.println(blockLists);
        return ResponseEntity.ok(blockLists);
    }


    @GetMapping("/admin/logincount") //find, update(count ++)
    public String adminLoginCount() {
        return "Admin Login Count";
    }

    @GetMapping("/admin/question") //find, complete, reply( if(find.moreThanOne) -> update)
    public String adminQuestion() {
        return "Admin Question";
    }

    @GetMapping("/user/question") //create
    public String userQuestion() {
        return "Admin Question";
    }

}
