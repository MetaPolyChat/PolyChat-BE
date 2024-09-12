package com.polychat.polychatbe.blockList.command.domain.service;

import com.polychat.polychatbe.blockList.command.domain.model.BlockList;
import com.polychat.polychatbe.blockList.command.domain.repository.BlockListRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BlockListDomainService {

    private final BlockListRepository blockListRepository;

    public BlockListDomainService(BlockListRepository blockListRepository) {
        this.blockListRepository = blockListRepository;
    }


    //create
//    @Transactional
    public void addToBlockList(Long userId, Long blockedUserId) throws IllegalArgumentException{
        blockListRepository.save(new BlockList(userId, blockedUserId, LocalDateTime.now()));

        blockListRepository.flush();
        System.out.println(blockListRepository.findAll());
    }

    //read
    @Deprecated
    public List<BlockList> findAllBlockList() {
        return blockListRepository.findAll();
    }

    //단일 검색 : key
    public BlockList findBlockListById(Long blockListId) {
        return blockListRepository.findById(blockListId).orElseThrow(()->
                new NoSuchElementException("ID에 해당하는 블락리스트가 없습니다."));
    }

    //단일 검색 : 유저 id
    @Deprecated
    public BlockList findByUserIdAndBlockedUserId(Long userId, Long blockedUserId) {
        System.out.println("userId : " + userId);
        System.out.println("blockedUserId : " + blockedUserId);
        BlockList blockList = blockListRepository.findByUserIdAndBlockedUserId(userId, blockedUserId).orElse(null);
        System.out.println(blockList);
        System.out.println(findBlockListByUserId(userId));
        System.out.println(findBlockedList(blockedUserId));
        return blockList;
    }

    //블락한 유저들
    public List<BlockList> findBlockListByUserId(Long userId) {
        return blockListRepository.findByUserId(userId).orElse(null);
    }

    //누구한테 블락 당했나
    public List<BlockList> findBlockedList(Long blockedUserId) {
        return blockListRepository.findByBlockedUserId(blockedUserId).orElse(null);
    }

    //update
    @Deprecated
    public void updateBlockList(Long blockListId) {
        throw new IllegalStateException("블락리스트는 업데이트 할 수 없습니다.");
    }

    //delete
    @Transactional
    public void deleteBlockList(Long blockListId) {
        blockListRepository.deleteById(blockListId);
    }


}
