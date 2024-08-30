package com.polychat.polychatbe.inerest;

import com.polychat.polychatbe.inerest.command.domain.service.InterestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class InterestTests {

    @Autowired
    private InterestService interestService;

    private static Stream<Arguments> createUserInterest() {
        return Stream.of(
                Arguments.of(
                        1L,
                        2L
                ),
                Arguments.of(
                        2L,
                        3L
                )
        );
    }

    @DisplayName("유저 관심사 테이블 생성 테스트")
    @ParameterizedTest
    @MethodSource("createUserInterest")
    public void testCreateUserInterest(Long userId, Long interestId) {


        Assertions.assertDoesNotThrow(() -> interestService.registUserInterest(userId, interestId));
    }




}
