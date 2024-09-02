package com.polychat.polychatbe.admin.command.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class adminPageController {


    @GetMapping("/admin")
    public String adminPage() {
        return "Admin Page";
    }
}
