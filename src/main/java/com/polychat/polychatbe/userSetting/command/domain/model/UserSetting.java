package com.polychat.polychatbe.userSetting.command.domain.model;

import jakarta.persistence.*;


@Entity
@Table(name="TBL_USER_SETTING")
public class UserSetting {

    @Id
    @Column(name = "user_id")
    private long userId;

    @Column(name = "music_volume")
    private int musicVolume;

    @Column(name = "effect_volume")
    private int effectVolume;

    @Column(name = "mute")
    private boolean mute;

    @Enumerated(EnumType.STRING)
    @Column(name = "chat_mode")
    private ChatMode chatMode;

    @Column(name = "enable_ai")
    private boolean enableAi;

    public UserSetting() {
    }

    public UserSetting(long userId, int musicVolume, int effectVolume, boolean mute,
                       ChatMode chatMode, boolean enableAi) {
        this.userId = userId;
        this.musicVolume = musicVolume;
        this.effectVolume = effectVolume;
        this.mute = mute;
        this.chatMode = chatMode;
        this.enableAi = enableAi;
    }

    public long getUserId() {
        return userId;
    }

    public int getMusicVolume() {
        return musicVolume;
    }

    public int getEffectVolume() {
        return effectVolume;
    }

    public boolean isMute() {
        return mute;
    }

    public ChatMode getChatMode() {
        return chatMode;
    }

    public boolean isEnableAi() {
        return enableAi;
    }

    public void updateUserSetting(UserSetting userSetting) {
        this.userId = userSetting.getUserId();
        this.musicVolume = userSetting.getMusicVolume();
        this.effectVolume = userSetting.getEffectVolume();
        this.mute = userSetting.isMute();
        this.chatMode = userSetting.getChatMode();
        this.enableAi = userSetting.isEnableAi();
    }

    @Override
    public String toString() {
        return "userSetting{" +
                "userId=" + userId +
                ", musicVolume=" + musicVolume +
                ", effectVolume=" + effectVolume +
                ", mute=" + mute +
                ", chatMode=" + chatMode +
                ", enableAi=" + enableAi +
                '}';
    }
}
