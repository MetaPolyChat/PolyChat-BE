package com.polychat.polychatbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // @CreatedDate 쓰기 위한 조건
public class PolychatBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolychatBeApplication.class, args);
    }

}
