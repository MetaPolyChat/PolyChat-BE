package com.polychat.polychatbe.friendBoard.service;

import com.polychat.polychatbe.common.PolyTime;
import com.polychat.polychatbe.friendBoard.dto.friendBoardDTO;
import com.polychat.polychatbe.friendBoard.entity.friendBoard;
import com.polychat.polychatbe.friendBoard.repository.FriendBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class friendBoardService {

    private final FriendBoardRepository re;

    public friendBoardService(FriendBoardRepository re) {
        this.re = re;
    }

    public void createFirendBoard(friendBoardDTO dto){
        friendBoard insertPost = friendBoard.builder()
                .title(dto.getTitle())
                .bodyText(dto.getBodyText())
                .userId(dto.userId)
                .build();
        re.save(insertPost);
    }

    public List<friendBoardDTO> getAllFriendBoardPosts(){
        List<friendBoard> friendBoardList = re.findAll();
        List<friendBoardDTO> friendBoardDTOList = new ArrayList<>();
        for (friendBoard post : friendBoardList) {
            friendBoardDTO dto = new friendBoardDTO(
                    post.getTitle(),
                    post.getBodyText(),
                    new PolyTime(post.getCreatedAt()).get(),
                    post.getUserId()
            );
            friendBoardDTOList.add(dto);
        }
        return friendBoardDTOList;
    }
}
