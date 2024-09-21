package com.polychat.polychatbe.interest.command.application.controller;

import com.polychat.polychatbe.interest.command.application.service.InterestAdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/interest")
public class AdminInterestController {

    private InterestAdminService interestAdminService;

    public AdminInterestController(InterestAdminService interestAdminService) {
        this.interestAdminService = interestAdminService;
    }

    @PostMapping("/regist")
    public ResponseEntity regist(@RequestParam String interest) {}
}
