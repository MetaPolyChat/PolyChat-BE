package com.polychat.polychatbe.friendBoard.controller;

import com.polychat.polychatbe.friendBoard.dto.friendBoardDTO;
import com.polychat.polychatbe.friendBoard.entity.friendBoard;
import com.polychat.polychatbe.friendBoard.service.friendBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/friendBoard")
public class friendBoardController {

    private final friendBoardService service;

    @Autowired
    public friendBoardController(friendBoardService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<friendBoard> createPost(@RequestBody friendBoardDTO dto) {
        System.out.println("Received data from React:");
        System.out.println("Title: " + dto.getBoard_title());
        System.out.println("Nickname: " + dto.getWriter());
        System.out.println("Content: " + dto.getBoard_content());

        // Convert DTO to Entity and save it
        friendBoard fb = dto.toEntity();
        friendBoard saved = service.save(fb);

        return ResponseEntity.ok().body(saved);
    }

    @GetMapping("/api/test")
    public String testEndpoint() {
        return "Spring Boot is running!";
    }

}
