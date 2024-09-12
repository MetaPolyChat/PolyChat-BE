package com.polychat.polychatbe.blockList.query.service;

import com.polychat.polychatbe.blockList.command.application.dto.BlockUserDTO;
import com.polychat.polychatbe.blockList.query.repository.BlockMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BlockListQueryService {

    private final BlockMapper blockMapper;

    public BlockListQueryService(BlockMapper blockMapper) {
        this.blockMapper = blockMapper;
    }

    public List<BlockUserDTO> findAllBlockList() {
        return blockMapper.findAllBlockList();
    }

    public BlockUserDTO findSingleBlockList(Long userId, Long blockedId) {
        List<BlockUserDTO> blockList = blockMapper.findSingleBlockList(userId, blockedId);
        System.out.println("Find block list : \n"+blockList + "\n");
        if (blockList == null || blockList.isEmpty()) {
            System.out.println("블락되어 있지 않습니다");
            return null;
        }
        return blockList.get(0);    // 중복 있을 때, 첫번째로 만들어진 항목 리턴
    }
}
