package com.polychat.polychatbe.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class PageItemResponse<T>{
    private final int totalCount;
    private final List<T> elements;
}
