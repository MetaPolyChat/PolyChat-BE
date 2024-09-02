package com.polychat.polychatbe.admin.command.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class adminPageController {


    @GetMapping("/admin")
    public String adminPage() {
        return "adminDashboard";
    }


    @GetMapping("/admin/blockuser")// block, release, find(count>5)
    public String adminBlockUser() {
        return "Admin Block User";
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
