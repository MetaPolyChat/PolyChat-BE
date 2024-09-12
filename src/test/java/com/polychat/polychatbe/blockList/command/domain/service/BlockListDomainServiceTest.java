package com.polychat.polychatbe.blockList.command.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlockListDomainServiceTest {

    @Autowired
    private BlockListDomainService blockListDomainService;

    @Test
    void addToBlockList() {
        Assertions.assertDoesNotThrow(()->{
            blockListDomainService.addToBlockList(1L,2L);
        });
    }

    @Test
    void findAllBlockList() {
    }

    @Test
    void findBlockListById() {
    }

    @Test
    void findByUserIdAndBlockedUserId() {
    }

    @Test
    void findBlockListByUserId() {
        Assertions.assertDoesNotThrow(()->{
            System.out.println(blockListDomainService.findBlockListByUserId(1L));
        });
    }

    @Test
    void findBlockedList() {
    }

    @Test
    void updateBlockList() {
    }

    @Test
    void deleteBlockList() {
    }
}