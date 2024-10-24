package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


// spring security 관련 설정 파일
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .anyRequest().permitAll()  // 모든 요청에 대해 인증을 요구하지 않음
            )
            .formLogin((form) -> form
                .loginPage("/login")  // 커스텀 로그인 페이지 설정
                .permitAll()
            )
            .logout((logout) -> logout.permitAll());  // 세미콜론 추가

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // 비밀번호 암호화를 위한 BCrypt
    }
}