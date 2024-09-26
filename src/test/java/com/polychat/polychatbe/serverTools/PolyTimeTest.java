package com.polychat.polychatbe.serverTools;

import com.polychat.polychatbe.blockList.command.application.dto.BlockUserDTO;
import com.polychat.polychatbe.blockList.command.domain.model.BlockList;
import com.polychat.polychatbe.blockList.command.domain.service.BlockListDomainService;
import com.polychat.polychatbe.blockList.query.service.BlockListQueryService;
import com.polychat.polychatbe.common.PolyTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PolyTimeTest {

    @Autowired
    BlockListQueryService blockListQueryService;

    @Autowired
    BlockListDomainService blockListDomainService;



//    @Test
//    void getRaw() {
//        Assertions.assertDoesNotThrow(()->{
//            List<BlockUserDTO> dtoList = blockListQueryService.findAllBlockList();
//            dtoList.forEach(blockUserDTO -> {
//                System.out.println(
//                        new PolyTime(blockUserDTO.getCreatedAt()).getRaw()
//                );
//            });
//        });
//    }
//
//    @Test
//    void get() {
//        Assertions.assertDoesNotThrow(()->{
//            List<BlockUserDTO> dtoList = blockListQueryService.findAllBlockList();
//            dtoList.forEach(blockUserDTO -> {
//                System.out.println(
//                        new PolyTime(blockUserDTO.getCreatedAt()).get()
//                );
//            });
//        });
//    }
//
//    @Test
//    void getDate() {
//        Assertions.assertDoesNotThrow(()->{
//            List<BlockUserDTO> dtoList = blockListQueryService.findAllBlockList();
//            dtoList.forEach(blockUserDTO -> {
//                System.out.println(
//                        new PolyTime(blockUserDTO.getCreatedAt()).getDate()
//                );
//            });
//        });
//    }
//
//    @Test
//    void getTime() {
//        Assertions.assertDoesNotThrow(()->{
//            List<BlockUserDTO> dtoList = blockListQueryService.findAllBlockList();
//            dtoList.forEach(blockUserDTO -> {
//                System.out.println(
//                        new PolyTime(blockUserDTO.getCreatedAt()).getTime()
//                );
//            });
//        });
//    }
//
//    @Test
//    void convertArrayListTest(){
//        Assertions.assertDoesNotThrow(()->{
//            List<BlockUserDTO> dtoList = blockListQueryService.findAllBlockList();
//            List<String> stringList = new ArrayList<>();
//            dtoList.forEach(blockUserDTO -> {
//                stringList.add(
//                        new PolyTime(blockUserDTO.getCreatedAt()).getRaw()
//                );
//            });
//            stringList.forEach(System.out::println);
//        });
//    }

    @Test
    void convertMapRawTest(){
        Assertions.assertDoesNotThrow(()->{
            List<BlockList> blockList = blockListDomainService.findAllBlockList();
            List<BlockUserDTO> dtoList = blockList
                    .stream()
                    .map(block -> new BlockUserDTO(
                                    block.getId(),
                                    block.getUserId(),
                                    block.getBlockedUserId(),
                                    new PolyTime(block.getCreatedAt()).getRaw()
                            )
                    )
                    .toList();
            dtoList.forEach(System.out::println);
        });
    }

    @Test
    void convertMapTest(){
        Assertions.assertDoesNotThrow(()->{
            List<BlockList> blockList = blockListDomainService.findAllBlockList();
            List<BlockUserDTO> dtoList = blockList
                    .stream()
                    .map(block -> new BlockUserDTO(
                                    block.getId(),
                                    block.getUserId(),
                                    block.getBlockedUserId(),
                                    new PolyTime(block.getCreatedAt()).get()
                            )
                    )
                    .toList();
            dtoList.forEach(System.out::println);
        });
    }

    @Test
    void convertDateTest(){
        Assertions.assertDoesNotThrow(()->{
            List<BlockList> blockList = blockListDomainService.findAllBlockList();
            List<BlockUserDTO> dtoList = blockList
                    .stream()
                    .map(block -> new BlockUserDTO(
                                    block.getId(),
                                    block.getUserId(),
                                    block.getBlockedUserId(),
                                    new PolyTime(block.getCreatedAt()).getDate()
                            )
                    )
                    .toList();
            dtoList.forEach(System.out::println);
        });
    }

    @Test
    void convertTimeTest(){
        Assertions.assertDoesNotThrow(()->{
            List<BlockList> blockList = blockListDomainService.findAllBlockList();
            List<BlockUserDTO> dtoList = blockList
                    .stream()
                    .map(block -> new BlockUserDTO(
                                    block.getId(),
                                    block.getUserId(),
                                    block.getBlockedUserId(),
                                    new PolyTime(block.getCreatedAt()).getTime()
                            )
                    )
                    .toList();
            dtoList.forEach(System.out::println);
        });
    }

    @Test
    void converterTest(){
        Assertions.assertDoesNotThrow(()->{
            List<BlockList> blockList = blockListDomainService.findAllBlockList();
            List<BlockUserDTO> dtoList = blockList
                    .stream()
                    .map(block -> new BlockUserDTO(
                                    block.getId(),
                                    block.getUserId(),
                                    block.getBlockedUserId(),
                                    PolyTime.PolyTimeConverter.convToStandardTime(block.getCreatedAt())
                            )
                    )
                    .toList();
            dtoList.forEach(System.out::println);
        });
    }
}