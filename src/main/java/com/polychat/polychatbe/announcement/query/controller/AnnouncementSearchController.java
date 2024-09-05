package com.polychat.polychatbe.announcement.query.controller;

import com.polychat.polychatbe.announcement.query.dto.AnnouncementResponseDTO;
import com.polychat.polychatbe.announcement.query.service.AnnouncementSearchService;
import com.polychat.polychatbe.common.SearchCriteriaInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class AnnouncementSearchController {

    private AnnouncementSearchService announcementSearchService;

    public AnnouncementSearchController(AnnouncementSearchService announcementSearchService) {
        this.announcementSearchService = announcementSearchService;
    }

    @Operation(summary = "공지사항 전체 조회", description = "전체 공지사항을 조회합니다.")
    @GetMapping("announcement")
    public ResponseEntity<List<AnnouncementResponseDTO>> getAnnouncementList(@ModelAttribute SearchCriteriaInfo searchCriteriaInfo) {

        if (searchCriteriaInfo !=null) {
            System.out.println(searchCriteriaInfo);
        } else{
            System.out.println("null임");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(announcementSearchService.findAllAnnouncement(), headers, HttpStatus.OK);

    }

    @Operation(summary = "공지사항 조회", description = "지정한 공지사항을 조회합니다.")
    @GetMapping("announcement/{id}")
    public ResponseEntity<AnnouncementResponseDTO> getAnnouncement(@PathVariable long id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(announcementSearchService.findAnnouncementById(id), headers, HttpStatus.OK);
    }
}
