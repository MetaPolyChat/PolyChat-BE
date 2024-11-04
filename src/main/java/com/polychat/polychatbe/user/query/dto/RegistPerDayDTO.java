package com.polychat.polychatbe.user.query.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class RegistPerDayDTO {
    private LocalDate date;
    private int registerCount;
}
