package com.polychat.polychatbe.friendBoard.controller;

import com.polychat.polychatbe.friendBoard.dto.friendBoardDTO;
import com.polychat.polychatbe.friendBoard.entity.friendBoard;
import com.polychat.polychatbe.friendBoard.service.friendBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/friendBoard")
public class friendBoardController {
    final friendBoardService service;

    @Autowired
    public friendBoardController(friendBoardService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<friendBoard> createPost(@RequestBody friendBoardDTO dto) {
        // 수신된 데이터 로그 출력
        System.out.println("Received data from React: " + dto);

        friendBoard fb = dto.toEntity();
        friendBoard saved = service.save(fb);

        // 저장된 데이터 로그 출력
        System.out.println("Saved data: " + saved);

        return ResponseEntity.ok().body(saved);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<friendBoardDTO>> getAllPosts() {
        List<friendBoard> posts = service.findAll();
        List<friendBoardDTO> dtos = posts.stream()
                .map(post -> {
                    friendBoardDTO dto = new friendBoardDTO();
                    dto.setTitle(post.getTitle());
                    dto.setContext(post.getContext());
                    dto.setNickname(post.getNickname());
                    dto.setUsernumber(post.getUsernumber().toString());
                    dto.setStartAt(post.getStartAt().toString());
                    dto.setEndAt(post.getEndAt().toString());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}
