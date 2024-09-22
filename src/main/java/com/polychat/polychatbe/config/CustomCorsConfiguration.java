package com.polychat.polychatbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomCorsConfiguration {

    public static String FRONT_URL = "http://localhost:3000";

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(FRONT_URL) // 허용할 출처 : 특정 도메인만 받을 수 있음
                        .allowedMethods("GET", "POST") // 허용할 HTTP method
                        .allowCredentials(true); // 쿠키 인증 요청 허용
            }
        };
    }
}
