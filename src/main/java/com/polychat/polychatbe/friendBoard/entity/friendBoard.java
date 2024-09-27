package com.polychat.polychatbe.friendBoard.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "friendBoard")
public class friendBoard {
    // 컬럼명 :  유저 아이디, 유저코드, 생성날짜, 내용, 타이틀,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String context;
    private String nickname;
    private Integer usernumber;
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    public friendBoard() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(Integer usernumber) {
        this.usernumber = usernumber;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }

    @Override
    public String toString() {
        return "friendBoard{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", nickname='" + nickname + '\'' +
                ", usernumber=" + usernumber +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                '}';
    }
}
