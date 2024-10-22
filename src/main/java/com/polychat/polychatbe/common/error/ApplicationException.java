package com.polychat.polychatbe.common.error;

import com.polychat.polychatbe.common.PolyTime;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApplicationException extends RuntimeException {

    private ErrorCode errorCode;
    private String timestamp;


    public ApplicationException(ErrorCode errorCode){
        this.errorCode = errorCode;
        this.timestamp = new PolyTime(LocalDateTime.now()).get();
    }
}