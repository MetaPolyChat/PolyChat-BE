package com.polychat.polychatbe.userSetting.command.domain.service;

import com.polychat.polychatbe.userSetting.command.application.service.UserSettingDTO;
import com.polychat.polychatbe.userSetting.command.domain.repository.UserSettingRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSettingDomainService {

    private final UserSettingRepository userSettingRepository;

    public UserSettingDomainService(UserSettingRepository userSettingRepository) {
        this.userSettingRepository = userSettingRepository;
    }

    public UserSettingDTO findUserSetting(long userId) {
        return userSettingRepository.findById(userId).map(UserSettingDTO::new).orElse(null);
    }
}
