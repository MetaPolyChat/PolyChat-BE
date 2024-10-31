package com.polychat.polychatbe.friendBoard.controller;

import com.polychat.polychatbe.friendBoard.dto.friendBoardDTO;
import com.polychat.polychatbe.friendBoard.entity.friendBoard;
import com.polychat.polychatbe.friendBoard.service.friendBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/friendBoard")
@Slf4j
@Tag(name = "친구 게시판 API", description = "친구를 모집하는 글을 올리는 게시판 API")
public class friendBoardController {

    private final com.polychat.polychatbe.friendBoard.service.friendBoardService friendBoardService;

    public friendBoardController(friendBoardService friendBoardService) {
        this.friendBoardService = friendBoardService;
    }

    @Operation(summary = "친구 게시글 등록", description = "친구 찾는 글 게시하는 기능")
    @PostMapping("/create")
    public ResponseEntity<String> createFriendBoard(@RequestBody friendBoardDTO friendBoardDTO) {
        // 로그로 받은 데이터 확인
        log.info("제목: " + friendBoardDTO.getTitle());
        log.info("내용: " + friendBoardDTO.getBodyText());
        log.info("날짜: " + friendBoardDTO.getDate());
        log.info("userId : " + friendBoardDTO.getUserId());


        friendBoardService.createFirendBoard(friendBoardDTO);
        // 성공 응답을 명확하게 설정 (200 OK)
        return ResponseEntity.status(HttpStatus.OK).body("게시판 데이터가 성공적으로 처리되었습니다.");
    }

    @Operation(summary = "친구 게시글 리스트 보기", description = "친구 리스트 보는 기능")
    @GetMapping("/listView")
    public ResponseEntity<List<friendBoardDTO>> getFriendBoardList() {
        List<friendBoardDTO> friendBoardList = friendBoardService.getAllFriendBoardPosts();
        log.info("friendBoardDTO :: " + friendBoardList);
        return ResponseEntity.status(HttpStatus.OK).body(friendBoardList);
    }



}
