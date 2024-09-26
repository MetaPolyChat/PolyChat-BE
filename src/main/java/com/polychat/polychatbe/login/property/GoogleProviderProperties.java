package com.polychat.polychatbe.login.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.security.oauth2.client.provider.google")
public class GoogleProviderProperties {
    private String tokenUri;
    private String userInfoUri;
    private String authorizationUri;
}