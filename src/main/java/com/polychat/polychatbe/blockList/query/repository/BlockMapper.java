package com.polychat.polychatbe.blockList.query.repository;

import com.polychat.polychatbe.blockList.command.application.dto.BlockUserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlockMapper {

    List<BlockUserDTO> findAllBlockList();

    List<BlockUserDTO> findSingleBlockList(Long userId, Long blockedUserId);
}
