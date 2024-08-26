package com.polychat.polychatbe.announcement.command.application.controller;

import com.polychat.polychatbe.announcement.command.application.dto.AnnounceAddRequest;
import com.polychat.polychatbe.announcement.command.application.service.AnnouncementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnounceController {

    private AnnouncementService announcementService;

    @PostMapping("/announce")
    public void addAnnouncement(AnnounceAddRequest announceAddRequest){

    }

}
