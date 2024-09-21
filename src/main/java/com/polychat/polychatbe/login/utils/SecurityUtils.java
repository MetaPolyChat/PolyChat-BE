package com.polychat.polychatbe.login.utils;


import com.polychat.polychatbe.login.error.ApplicationException;
import com.polychat.polychatbe.login.error.ErrorCode;
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
