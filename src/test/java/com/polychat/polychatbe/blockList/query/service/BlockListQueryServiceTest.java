package com.polychat.polychatbe.blockList.query.service;


import com.polychat.polychatbe.blockList.command.application.dto.BlockUserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

@SpringBootTest
class BlockListQueryServiceTest {

    @Autowired
    BlockListQueryService blockListQueryService;

    @Test
    void findAllBlockList() {
        List<BlockUserDTO> blockUserDTOList = blockListQueryService.findAllBlockList();
        Assertions.assertNotNull(blockUserDTOList);
        System.out.println(blockUserDTOList);
    }

    private static Stream<Arguments> setBlockTestValue(){
        return Stream.of(
                Arguments.of(1L, 2L, false),
                Arguments.of(2L, 1L, false),
                Arguments.of(123L, 666L, true),
                Arguments.of(666L,123L, false),
                Arguments.of(666L,111L, true),
                Arguments.of(123L,111L, false)
        );
    }

    @Deprecated
    @ParameterizedTest
    @MethodSource("setBlockTestValue")
    void findSingleBlockList(Long userId, Long blockedUserId, boolean expectException) {
        if (expectException){
            Assertions.assertThrows(NoSuchElementException.class, () ->
                    blockListQueryService.findSingleBlockList(userId, blockedUserId));
        }else {
            BlockUserDTO findDTO = blockListQueryService.findSingleBlockList(userId, blockedUserId);
            Assertions.assertNotNull(findDTO);
            System.out.println(findDTO);
        }
    }

    @ParameterizedTest
    @MethodSource("setBlockTestValue")
    void findSingleBlockListNull(Long userId, Long blockedUserId, boolean expectNull) {
        if (expectNull){
            BlockUserDTO findDTO = blockListQueryService.findSingleBlockList(userId, blockedUserId);
            Assertions.assertNull(findDTO);
        }else {
            BlockUserDTO findDTO = blockListQueryService.findSingleBlockList(userId, blockedUserId);
            Assertions.assertNotNull(findDTO);
            System.out.println(findDTO);
        }
    }


}