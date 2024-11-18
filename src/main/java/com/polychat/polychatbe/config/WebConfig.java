//package com.polychat.polychatbe.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    String[] allowCorsUrl = {
//            "http://localhost:3000",
//            "http://localhost:61981"
//    };
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*") //임시로 전역으로 설정
//                //.allowedOrigins("http://localhost:3000") // React 앱의 URL
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                .allowedHeaders("*");
//                //.allowCredentials(true);
//    }
//}
