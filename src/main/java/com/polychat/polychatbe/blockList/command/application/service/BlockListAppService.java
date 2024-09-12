package com.polychat.polychatbe.blockList.command.application.service;

import com.polychat.polychatbe.blockList.command.application.dto.BlockUserDTO;
import com.polychat.polychatbe.blockList.command.domain.model.BlockList;
import com.polychat.polychatbe.blockList.command.domain.service.BlockListDomainService;
import com.polychat.polychatbe.blockList.query.service.BlockListQueryService;
import com.polychat.polychatbe.serverTools.PolyTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlockListAppService {

    private final BlockListDomainService blockListDomainService;
    private final BlockListQueryService blockListQueryService;

    public BlockListAppService(BlockListDomainService blockListDomainService,
                               BlockListQueryService blockListQueryService) {
        this.blockListDomainService = blockListDomainService;
        this.blockListQueryService = blockListQueryService;
    }

    public List<BlockUserDTO> getAllBlockLists() {
        List<BlockUserDTO> blockUserDTO = blockListQueryService.findAllBlockList();
        blockUserDTO.forEach(
                dto -> {
                    dto.setCreatedAt(new PolyTime(dto.getCreatedAt()).get());
                }
        );
        return blockUserDTO;
    }

    public BlockUserDTO getBlockById(Long userId, Long blockedUserId) {
        return blockListQueryService.findSingleBlockList(userId, blockedUserId);
    }

    @Transactional
    public void blockUser(Long userId, Long blockedUserId) throws IllegalArgumentException {
        // 없으면 저장
        if (blockListQueryService.findSingleBlockList(userId, blockedUserId) == null) {
            System.out.println(blockedUserId + " : 블락되어 있지 않습니다");
            blockListDomainService.addToBlockList(userId, blockedUserId);
        }else {
            System.out.println("이 유저는 이미 블락 되어 있습니다.");
            throw new IllegalArgumentException("이 유저는 이미 블락 되어 있습니다.");
        }
    }

    @Transactional
    public void unblockUser(Long userId, Long blockedUserId) {
        BlockList blockList = blockListDomainService.findByUserIdAndBlockedUserId(userId, blockedUserId);
        if (blockList != null) {
            blockListDomainService.deleteBlockList(blockList.getId());
        }
    }

    public List<BlockList> getListUserBlockOthers(Long userId) {
        return blockListDomainService.findBlockListByUserId(userId);
    }

    public List<BlockList> getListBlockedByOthers(Long blockedUserId) {
        return blockListDomainService.findBlockListByUserId(blockedUserId);
    }



}
