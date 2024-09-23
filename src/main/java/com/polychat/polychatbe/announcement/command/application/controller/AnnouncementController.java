package com.polychat.polychatbe.announcement.command.application.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.polychat.polychatbe.announcement.command.application.dto.AnnounceAddRequest;
import com.polychat.polychatbe.announcement.command.application.dto.AnnouncementDeleteRequest;
import com.polychat.polychatbe.announcement.command.application.service.AnnouncementService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("/api/v1")
@Slf4j
@CrossOrigin(origins = "*", methods = RequestMethod.POST)
public class AnnouncementController {

    private AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @Operation(summary = "공지사항 등록", description = "공지사항을 등록합니다.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/announcement")
    public void addAnnouncement(@ModelAttribute AnnounceAddRequest announceAddRequest){
        log.info("Creating new announcement. Title:{}, UploaderId:{}",
                announceAddRequest.getTitle(), announceAddRequest.getUploaderId());
        //System.out.println("announceAddRequest = " + announceAddRequest);
        announcementService.addAnnouncement(announceAddRequest);
    }


    @Operation(summary = "공지사항 수정", description = "공지사항을 수정합니다.")
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/announcement/{id}")
    public void updateAnnouncement(@PathVariable long id, AnnounceAddRequest announceAddRequest) {
        log.info("Updating announcement. AnnouncementId:{} Title:{} UploaderId:{}",
                announceAddRequest.getAnnouncementId(), announceAddRequest.getTitle(),
                announceAddRequest.getUploaderId());
        announceAddRequest.setAnnouncementId(id);
        announcementService.updateAnnouncement(announceAddRequest);
        log.info("Update Successful.");
    }

    @Operation(summary = "공지사항 삭제", description = "공지사항을 삭제합니다.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/announcement/{id}")
    public void deleteAnnouncement(@PathVariable long id, @RequestBody AnnouncementDeleteRequest deleteInfo){
        //System.out.println(userNo);
        log.info("Deleting announcement. AnnouncementId: {}", id);
        announcementService.deleteAnnouncement(id, deleteInfo);
    }

}
