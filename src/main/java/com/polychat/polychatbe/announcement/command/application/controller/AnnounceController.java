package com.polychat.polychatbe.announcement.command.application.controller;

import com.polychat.polychatbe.announcement.command.application.dto.AnnounceAddRequest;
import com.polychat.polychatbe.announcement.command.application.service.AnnouncementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1")
public class AnnounceController {

    private AnnouncementService announcementService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/announcement")
    public void addAnnouncement(AnnounceAddRequest announceAddRequest){
        announcementService.addAnnouncement(announceAddRequest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/announcement/{id}")
    public void updateAnnouncement(@PathVariable long id, AnnounceAddRequest announceAddRequest) {
        announceAddRequest.setAnnouncementId(id);
        announcementService.updateAnnouncement(announceAddRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/announcement/{id}")
    public void deleteAnnouncement(@PathVariable long id, @RequestBody long userNo){
        announcementService.deleteAnnouncement(id, userNo);
    }

}
