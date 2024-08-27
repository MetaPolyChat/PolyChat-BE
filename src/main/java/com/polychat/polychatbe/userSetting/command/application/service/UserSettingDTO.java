package com.polychat.polychatbe.userSetting.command.application.service;

import com.polychat.polychatbe.userSetting.command.domain.model.ChatMode;
import com.polychat.polychatbe.userSetting.command.domain.model.UserSetting;

public class UserSettingDTO {
    private int musicVolume;
    private int effectVolume;
    private boolean mute;
    private ChatMode chatMode;
    private boolean enableAi;

    public UserSettingDTO() {
    }

    public UserSettingDTO(int musicVolume, int effectVolume, boolean mute, ChatMode chatMode, boolean enableAi) {
        this.musicVolume = musicVolume;
        this.effectVolume = effectVolume;
        this.mute = mute;
        this.chatMode = chatMode;
        this.enableAi = enableAi;
    }

    public UserSettingDTO(UserSetting userSetting) {
        this(
                userSetting.getMusicVolume(),
                userSetting.getEffectVolume(),
                userSetting.isMute(),
                userSetting.getChatMode(),
                userSetting.isEnableAi()
        );
    }

    public int getMusicVolume() {
        return musicVolume;
    }

    public void setMusicVolume(int musicVolume) {
        this.musicVolume = musicVolume;
    }

    public int getEffectVolume() {
        return effectVolume;
    }

    public void setEffectVolume(int effectVolume) {
        this.effectVolume = effectVolume;
    }

    public boolean isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    public ChatMode getChatMode() {
        return chatMode;
    }

    public void setChatMode(ChatMode chatMode) {
        this.chatMode = chatMode;
    }

    public boolean isEnableAi() {
        return enableAi;
    }

    public void setEnableAi(boolean enableAi) {
        this.enableAi = enableAi;
    }

    @Override
    public String toString() {
        return "UserSettingDTO{" +
                "musicVolume=" + musicVolume +
                ", effectVolume=" + effectVolume +
                ", mute=" + mute +
                ", chatMode=" + chatMode +
                ", enableAi=" + enableAi +
                '}';
    }
}
