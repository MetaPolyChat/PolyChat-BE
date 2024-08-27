package com.polychat.polychatbe.announcement.query.controller;

import com.polychat.polychatbe.announcement.query.dto.AnnouncementResponseDTO;
import com.polychat.polychatbe.announcement.query.service.AnnouncementSearchService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class AnnouncementSearchController {

    private AnnouncementSearchService announcementSearchService;

    public AnnouncementSearchController(AnnouncementSearchService announcementSearchService) {
        this.announcementSearchService = announcementSearchService;
    }

    @GetMapping("announcement")
    public ResponseEntity<List<AnnouncementResponseDTO>> getAnnouncementList() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(announcementSearchService.findAllAnnouncement(), headers, HttpStatus.OK);

    }

    @GetMapping("announcement/{id}")
    public ResponseEntity<AnnouncementResponseDTO> getAnnouncement(@PathVariable long id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(announcementSearchService.findAnnouncementById(id), headers, HttpStatus.OK);
    }
}
