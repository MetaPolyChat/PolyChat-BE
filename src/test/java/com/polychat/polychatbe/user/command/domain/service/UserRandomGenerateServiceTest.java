package com.polychat.polychatbe.user.command.domain.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRandomGenerateServiceTest {

    @Autowired
    UserRandomGenerateService userRandomGenerateService;

    @Test
    public void generate() {
        System.out.println(userRandomGenerateService.generatePlanetCode());
    }


}