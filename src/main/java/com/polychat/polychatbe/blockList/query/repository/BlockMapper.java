package com.polychat.polychatbe.blockList.query.repository;

import com.polychat.polychatbe.blockList.query.dto.BlockFindDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlockMapper {

    List<BlockFindDTO> findAllBlockList();
}
