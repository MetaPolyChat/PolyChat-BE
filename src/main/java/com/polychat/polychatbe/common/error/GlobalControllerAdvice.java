package com.polychat.polychatbe.common.error;


import com.polychat.polychatbe.common.PolyTime;
import com.polychat.polychatbe.common.utils.ApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<?> applicationHandler(ApplicationException e){
        log.error("Error occurs {}", e.toString());

        Map<String,Object> data = new HashMap<>();
        data.put("status",e.getErrorCode().getStatus().value());
        data.put("errorCode", e.getErrorCode().getErrorCode());
        data.put("message",e.getErrorCode().getMessage());
        data.put("timestamp", e.getTimestamp());

        return ResponseEntity.status(e.getErrorCode().getStatus()).body(ApiUtils.error(data));
    }

    @ExceptionHandler(NullfieldException.class)
    public ResponseEntity<?> applicationHandler(NullfieldException e){
        log.error("Null field Exception {}", e.getMessage());

        Map<String,Object> data = new HashMap<>();
        data.put("status",e.getStatus().value());
        data.put("errorCode", e.getErrorCode());
        data.put("message",e.getMessage());
        data.put("timestamp", e.getTimestamp());

        return ResponseEntity.status(e.getStatus()).body(ApiUtils.error(data));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> applicationHandler(Exception e){
        log.error("Unexpected Error occurs {}", e.getMessage());

        ErrorCode error = ErrorCode.INTERNAL_SERVER_ERROR;

        Map<String,Object> data = new HashMap<>();
        data.put("status",error.getStatus().value());
        data.put("errorCode", error.getErrorCode());
        data.put("message",e.getMessage());
        data.put("timestamp", new PolyTime(LocalDateTime.now()));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiUtils.error(data));
    }
}