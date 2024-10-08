package com.polychat.polychatbe.login.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.security.oauth2.client.registration.google")
public class GoogleRegistrationProperties {
    private String clientId;
    private String clientSecret;
    private String scope;
    private String redirectUri;
    private String authorizationGrantType;
}
