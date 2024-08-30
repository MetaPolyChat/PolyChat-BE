package com.polychat.polychatbe.userSetting.command.application.controller;

import com.polychat.polychatbe.userSetting.command.application.service.UserSettingAppService;
import org.springframework.stereotype.Controller;

@Controller
public class UserSettingController {
    private final UserSettingAppService userSettingAppService;

    public UserSettingController(UserSettingAppService userSettingAppService) {
        this.userSettingAppService = userSettingAppService;
    }
}
