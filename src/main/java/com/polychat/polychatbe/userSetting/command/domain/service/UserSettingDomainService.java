package com.polychat.polychatbe.userSetting.command.domain.service;

import com.polychat.polychatbe.userSetting.command.application.service.UserSettingDTO;
import com.polychat.polychatbe.userSetting.command.domain.model.UserSetting;
import com.polychat.polychatbe.userSetting.command.domain.repository.UserSettingRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSettingDomainService {

    private final UserSettingRepository userSettingRepository;

    public UserSettingDomainService(UserSettingRepository userSettingRepository) {
        this.userSettingRepository = userSettingRepository;
    }

    public UserSetting findUserSetting(long userId) {
        return userSettingRepository.findById(userId).orElse(null);
    }

    public void updateUserSetting(UserSettingDTO userSettingDTO) {

    }

    public void initailizeUserSetting(UserSettingDTO userSettingDTO) {


    }




    public void deleteUserSetting(long userId) {}

}
