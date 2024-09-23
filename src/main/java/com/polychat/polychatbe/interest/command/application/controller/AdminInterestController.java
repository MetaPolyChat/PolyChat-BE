package com.polychat.polychatbe.interest.command.application.controller;

import com.polychat.polychatbe.interest.command.application.service.InterestAdminService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/interest")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminInterestController {

    private final InterestAdminService interestAdminService;

    public AdminInterestController(InterestAdminService interestAdminService) {
        this.interestAdminService = interestAdminService;
    }

    // Test endpoint to check if the server is running
    @GetMapping("/test")
    public ResponseEntity<String> testConnection(HttpServletResponse response) {
        response.setHeader("Cross-Origin-Opener-Policy", "same-origin");
        response.setHeader("Cross-Origin-Embedder-Policy", "require-corp");
        System.out.println("test실행");
        return ResponseEntity.ok("Server is running");
    }



    @PostMapping("/regist")
    public ResponseEntity<?> regist(@RequestBody Map<String, Object> request) {
        String nickname = (String) request.get("nickname");
        List<String> interests = (List<String>) request.get("interests");

        if (nickname == null || interests == null || interests.isEmpty()) {
            System.out.println("Error: Missing nickname or interests");
            return ResponseEntity.badRequest().body("Nickname or interests are missing");
        }

        System.out.println("Received nickname: " + nickname);
        System.out.println("Received interests: " + interests);
        System.out.println("Number of interests selected: " + interests.size());

        return ResponseEntity.ok("Interests registered successfully");
    }
}
