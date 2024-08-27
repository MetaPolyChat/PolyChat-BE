package com.polychat.polychatbe.userSetting.command.application.service;

import com.polychat.polychatbe.userSetting.command.domain.model.UserSetting;
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

    public UserSettingDTO findUserSetting(long userId) {
        return new UserSettingDTO(userSettingDomainService.findUserSetting(userId));
    }


    public void initializeNewUserSetting(long userId) {
        UserSettingDTO userSettingDTO = new UserSettingDTO();
        userSettingDomainService.initailizeUserSetting(userSettingDTO.setDefault(userId));
    }

    public void updateUserSetting(UserSettingDTO userSettingDTO) {
        UserSetting userSetting = userSettingDomainService.findUserSetting(userSettingDTO.getUserId());

    }
}
