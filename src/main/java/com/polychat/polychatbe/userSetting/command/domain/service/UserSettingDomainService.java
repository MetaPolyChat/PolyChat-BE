package com.polychat.polychatbe.userSetting.command.domain.service;

import com.polychat.polychatbe.userSetting.command.application.service.UserSettingDTO;
import com.polychat.polychatbe.userSetting.command.domain.model.UserSetting;
import com.polychat.polychatbe.userSetting.command.domain.repository.UserSettingRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserSettingDomainService {

    private final UserSettingRepository userSettingRepository;

    public UserSettingDomainService(UserSettingRepository userSettingRepository) {
        this.userSettingRepository = userSettingRepository;
    }

    public UserSetting findUserSetting(long userId) throws NoSuchElementException {
        UserSetting  userSetting=  userSettingRepository.findById(userId).orElse(null);
        if (userSetting == null) {
            throw new NoSuchElementException("존재 하지 않는 유저입니다.");
        }else {
            return userSetting;
        }
    }


    public void updateUserSetting(UserSetting newSetting) {
        UserSetting existSetting = findUserSetting(newSetting.getUserId());
        existSetting.updateUserSetting(newSetting);
        userSettingRepository.save(existSetting);
    }

    public void createUserSetting(UserSetting userSetting) {
        userSettingRepository.save(userSetting);
    }


    public void deleteUserSetting(long userId) {
        userSettingRepository.deleteById(userId);
    }

}
