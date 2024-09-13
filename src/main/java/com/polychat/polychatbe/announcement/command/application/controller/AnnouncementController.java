package com.polychat.polychatbe.announcement.command.application.controller;

import com.polychat.polychatbe.announcement.command.application.dto.AnnounceAddRequest;
import com.polychat.polychatbe.announcement.command.application.service.AnnouncementService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1")
public class AnnouncementController {

    private AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @Operation(summary = "공지사항 등록", description = "공지사항을 등록합니다.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/announcement")
    public void addAnnouncement(AnnounceAddRequest announceAddRequest){
        System.out.println("announceAddRequest = " + announceAddRequest);
        announcementService.addAnnouncement(announceAddRequest);
    }


    @Operation(summary = "공지사항 수정", description = "공지사항을 수정합니다.")
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/announcement/{id}")
    public void updateAnnouncement(@PathVariable long id, AnnounceAddRequest announceAddRequest) {
        announceAddRequest.setAnnouncementId(id);
        announcementService.updateAnnouncement(announceAddRequest);
    }

    @Operation(summary = "공지사항 삭제", description = "공지사항을 삭제합니다.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/announcement/{id}")
    public void deleteAnnouncement(@PathVariable long id, @RequestBody long userNo){
        announcementService.deleteAnnouncement(id, userNo);
    }

}
