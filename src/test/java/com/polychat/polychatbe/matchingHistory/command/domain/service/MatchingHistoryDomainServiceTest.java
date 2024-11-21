package com.polychat.polychatbe.matchingHistory.command.domain.service;

import com.polychat.polychatbe.matchingHistory.command.domain.model.MatchingHistory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MatchingHistoryDomainServiceTest {

    @Autowired
    MatchingHistoryDomainService matchingHistoryDomainService;


    @Test
    public void findAllMatchingHistory(){
        List<MatchingHistory> matchingHistoryList;
        Assertions.assertDoesNotThrow(
                () -> {
                    matchingHistoryDomainService.findAllMatchingHistory().forEach(System.out::println);
                }
        );
    }

//    private static Stream<Arguments> newMatchingHistory() {
//        return Stream.of(
//                Arguments.of(
//                        new MatchingHistory(
//                                231L,
//                                16L,
//                                "",
//                                false
//                        )
//                )
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("newMatchingHistory")
//    public void createMatchingHistory(MatchingHistory newMatchingHistory){
//        Assertions.assertDoesNotThrow(()->{
//            matchingHistoryDomainService.createNewMatchingHistory(newMatchingHistory);
//            matchingHistoryDomainService.findAllMatchingHistory().forEach(System.out::println);
//        });
//
//    }

    @ParameterizedTest
    @ValueSource(longs = 23L)
    public void findByUserIdTest(Long userId){
        Assertions.assertDoesNotThrow(()->{
            matchingHistoryDomainService.findMatchingHistory(userId).forEach(System.out::println);
        });
    }

}