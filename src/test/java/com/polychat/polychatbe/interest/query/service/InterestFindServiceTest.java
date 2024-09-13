package com.polychat.polychatbe.interest.query.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InterestFindServiceTest {

    @Autowired
    private InterestFindService interestFindService;

    @DisplayName("전체 관심사 조회")
    @Test
    void findAllInterests() {
        Assertions.assertDoesNotThrow(() -> {
            System.out.println(interestFindService.findAllInterests());
        });
    }

    @DisplayName("관심사 번호로 관심사 조회")
    @Test
    void findInterestByInterestNo() {
        Assertions.assertDoesNotThrow(() -> {
            System.out.println(interestFindService.findInterestByInterestNo(3L));
        });
    }

    @Test
    void findInterestByInterestName() {
    }

    @Test
    void findInterestNoByInterestName() {
    }

    @Test
    void findInterestNameByInterestNo() {
    }

    @Test
    void findUserInterestsByUserId() {
    }

    @Test
    void findUserInterestByInterestName() {
    }

    @Test
    void findUsersByInterestName() {
    }
}