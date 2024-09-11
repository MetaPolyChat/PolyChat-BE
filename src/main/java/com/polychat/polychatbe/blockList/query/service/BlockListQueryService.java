package com.polychat.polychatbe.blockList.query.service;

import com.polychat.polychatbe.blockList.command.domain.model.BlockList;
import com.polychat.polychatbe.blockList.query.dto.BlockFindDTO;
import com.polychat.polychatbe.blockList.query.repository.BlockMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockListQueryService {

    BlockMapper blockMapper;

    public List<BlockFindDTO> findAllBlockList() {
        List<BlockFindDTO> blockList = new ArrayList<BlockFindDTO>();
        return blockMapper.findAllBlockList();
    }
}
