package com.polychat.polychatbe.userSetting.command.application.service;

import com.polychat.polychatbe.userSetting.command.domain.model.UserSetting;
import com.polychat.polychatbe.userSetting.command.domain.service.UserSettingDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

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
        try {
            userSettingDomainService.findUserSetting(userId);
            throw new IllegalArgumentException("유저 설정이 이미 존재합니다.");
        }catch (NoSuchElementException e) {
            UserSettingDTO userSettingDTO = new UserSettingDTO();
            userSettingDTO.setDefault(userId);
            userSettingDomainService.createUserSetting(convertDTOToUserSetting(userSettingDTO));
        }
    }

    public void makeUserSettingDefault(long userId) {
        UserSetting userSetting = userSettingDomainService.findUserSetting(userId);
        UserSettingDTO userSettingDTO = convertUserSettingToDTO(userSetting);
        userSettingDTO.setDefault(userId);
        updateUserSetting(userSettingDTO);
    }

    public void updateUserSetting(UserSettingDTO userSettingDTO) {
        userSettingDomainService.updateUserSetting(convertDTOToUserSetting(userSettingDTO));
    }

    private UserSetting convertDTOToUserSetting(UserSettingDTO userSettingDTO) {
        return new UserSetting(
                userSettingDTO.getUserId(),
                userSettingDTO.getMusicVolume(),
                userSettingDTO.getEffectVolume(),
                userSettingDTO.isMute(),
                userSettingDTO.getChatMode(),
                userSettingDTO.isEnableAi()
        );
    }

    private UserSettingDTO convertUserSettingToDTO(UserSetting userSetting) {
        return new UserSettingDTO(userSetting);
    }

}

