package com.polychat.polychatbe.userSetting.command.application.service;

import com.polychat.polychatbe.userSetting.command.domain.repository.UserSettingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserSettingAppServiceTest {

    @Autowired
    private UserSettingAppService userSettingAppService;


    @ParameterizedTest
    @ValueSource(longs = 4)
    public void getUserSetting(long userId) {
//        Assertions.assertThrows(NoSuchElementException.class, () -> {
//            userSettingAppService.findUserSetting(userId);
//        });
        Assertions.assertDoesNotThrow(() -> {
            userSettingAppService.findUserSetting(userId);
        });
    }

    @ParameterizedTest
    @ValueSource(longs = 4)
    public void newUserSetting(long userId) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userSettingAppService.initializeNewUserSetting(userId);
        });
    }
}