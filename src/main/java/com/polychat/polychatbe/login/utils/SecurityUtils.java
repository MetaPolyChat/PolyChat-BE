package com.polychat.polychatbe.login.utils;

import com.backend.voicetuner.login._core.error.ApplicationException;
import com.backend.voicetuner.login._core.error.ErrorCode;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static Long getCurrentMemberId() {

        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        if(name.equals("anonymousUser")) {
            throw new ApplicationException(ErrorCode.ANONYMOUS_USER);
        }

        return Long.parseLong(name);
    }
}
