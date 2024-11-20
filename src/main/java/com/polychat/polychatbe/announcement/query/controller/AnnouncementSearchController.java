package com.polychat.polychatbe.announcement.query.controller;

import com.polychat.polychatbe.announcement.query.dto.AnnouncementResponseDTO;
import com.polychat.polychatbe.announcement.query.service.AnnouncementSearchService;
import com.polychat.polychatbe.common.PageItemResponse;
import com.polychat.polychatbe.common.SearchCriteriaInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Tag(name = "공지사항 조회 API", description = "공지사항을 조회하기 위한 API")
public class AnnouncementSearchController {

    private AnnouncementSearchService announcementSearchService;

    public AnnouncementSearchController(AnnouncementSearchService announcementSearchService) {
        this.announcementSearchService = announcementSearchService;
    }

    @Operation(summary = "공지사항 전체 조회", description = "전체 공지사항을 조회합니다.")
    @GetMapping("announcement")
    public ResponseEntity<List<AnnouncementResponseDTO>> getAnnouncementList(
            @Valid @ModelAttribute SearchCriteriaInfo searchCriteriaInfo,
            @RequestParam(required = false) String test) {

        System.out.println(searchCriteriaInfo);
        System.out.println(test);

        //List<AnnouncementResponseDTO> announcementList = announcementSearchService.findAllAnnouncement();
        List<AnnouncementResponseDTO> announcementList = announcementSearchService.findAnnouncementList(
                searchCriteriaInfo);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(announcementList, headers, HttpStatus.OK);

    }

    @Operation(summary = "공지사항 조회", description = "지정한 공지사항을 조회합니다.")
    @GetMapping("announcement/{id}")
    public ResponseEntity<AnnouncementResponseDTO> getAnnouncement(@PathVariable long id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(announcementSearchService.findAnnouncementById(id), headers, HttpStatus.OK);
    }

    @Operation(summary = "공지사항 조회 페이지", description = "페이지별로 공지사항 조회.")
    @GetMapping("announcement/page")
    public ResponseEntity<PageItemResponse<AnnouncementResponseDTO>> getAnnouncementWithPage(
            @Valid @ModelAttribute SearchCriteriaInfo searchCriteriaInfo
    ) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(
                new PageItemResponse<>(
                        announcementSearchService.countAll(),
                        announcementSearchService.findAnnouncementList(searchCriteriaInfo)),
                headers, HttpStatus.OK);
    }
}
