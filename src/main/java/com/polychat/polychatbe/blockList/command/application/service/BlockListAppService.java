package com.polychat.polychatbe.blockList.command.application.service;

import com.polychat.polychatbe.blockList.command.domain.model.BlockList;
import com.polychat.polychatbe.blockList.command.domain.service.BlockListDomainService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockListAppService {

    private final BlockListDomainService blockListDomainService;

    public BlockListAppService(BlockListDomainService blockListDomainService) {
        this.blockListDomainService = blockListDomainService;
    }

    public List<BlockList> getAllBlockLists() {
        return blockListDomainService.findAllBlockList();
    }

    public void blockUser(Long userId, Long blockedUserId) {
        blockListDomainService.addToBlockList(userId, blockedUserId);
    }

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
