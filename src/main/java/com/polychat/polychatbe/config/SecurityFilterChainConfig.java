package com.polychat.polychatbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterChainConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 요청에 대한 인증 설정
                .authorizeHttpRequests(authorize -> authorize
                        // 구글 리디렉션 엔드포인트는 모두 접근 허용
                        .requestMatchers("/api/auth").permitAll()
                        // 기타 엔드포인트는 인증 필요
                        .anyRequest().authenticated()
                )
                // 폼 로그인 비활성화 (필요한 경우)
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
