package com.polychat.polychatbe.userSetting.command.domain.repository;

import com.polychat.polychatbe.userSetting.command.domain.model.UserSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSettingRepository extends JpaRepository<UserSetting, Long> {
}
