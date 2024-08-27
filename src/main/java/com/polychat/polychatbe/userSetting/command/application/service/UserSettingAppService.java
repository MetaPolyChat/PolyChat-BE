package com.polychat.polychatbe.userSetting.command.application.service;

import com.polychat.polychatbe.userSetting.command.domain.service.UserSettingDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSettingAppService {

    private final UserSettingDomainService userSettingDomainService;

    @Autowired
    public UserSettingAppService(UserSettingDomainService userSettingDomainService) {
        this.userSettingDomainService = userSettingDomainService;
    }
}
