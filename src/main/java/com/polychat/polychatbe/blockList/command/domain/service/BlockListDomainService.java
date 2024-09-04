package com.polychat.polychatbe.blockList.command.domain.service;

import com.polychat.polychatbe.blockList.command.domain.model.BlockList;
import com.polychat.polychatbe.blockList.command.domain.repository.BlockListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BlockListDomainService {

    private final BlockListRepository blockListRepository;

    public BlockListDomainService(BlockListRepository blockListRepository) {
        this.blockListRepository = blockListRepository;
    }


    //create
    public void addToBlockList(Long userId, Long blockedUserId) {
        BlockList blockList = this.findByUserIdAndBlockedUserId(userId, blockedUserId);
        if (blockList != null) {
            throw new IllegalArgumentException("이 유저는 이미 블락 되어 있습니다.");
        }else {
            blockListRepository.save(new BlockList(userId, blockedUserId));
        }
    }

    //read
    public List<BlockList> findAllBlockList() {
        return blockListRepository.findAll();
    }

    public BlockList findBlockListById(Long blockListId) {
        return blockListRepository.findById(blockListId).orElseThrow(()->
                new NoSuchElementException("ID에 해당하는 블록리스트가 없습니다."));
    }

    public BlockList findByUserIdAndBlockedUserId(Long userId, Long blockedUserId) {
        return blockListRepository.findByUserIdAndBlockedUserId(userId, blockedUserId);
    }

    public List<BlockList> findBlockListByUserId(Long userId) {
        return blockListRepository.findByUserId(userId);
    }

    public List<BlockList> findBlockedList(Long blockedUserId) {
        return blockListRepository.findByBlockedUserId(blockedUserId);
    }

    //update
    @Deprecated
    public void updateBlockList(Long blockListId) {
        throw new IllegalStateException("블록리스트는 업데이트 할 수 없습니다.");
    }

    //delete
    public void deleteBlockList(Long blockListId) {
        blockListRepository.deleteById(blockListId);
    }


}
