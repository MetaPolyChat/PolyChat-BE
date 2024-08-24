package com.polychat.polychatbe.announcement.query.controller;

import com.polychat.polychatbe.announcement.query.dto.AnnouncementResponseDTO;
import com.polychat.polychatbe.announcement.query.service.AnnouncementSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnnouncementSearchController {

    private AnnouncementSearchService announcementSearchService;

    public AnnouncementSearchController(AnnouncementSearchService announcementSearchService) {
        this.announcementSearchService = announcementSearchService;
    }

    @GetMapping("announcement")
    public List<AnnouncementResponseDTO> getAnnouncementList() {

        return announcementSearchService.findAllAnnouncement();
    }

    @GetMapping("announcement/{id}")
    public AnnouncementResponseDTO getAnnouncement(@PathVariable long id) {

        return announcementSearchService.findAnnouncementById(id);
    }
}
