package com.ecommerce.userservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Disable CSRF (Crucial for Postman/cURL testing)
                .csrf(csrf -> csrf.disable())

                // 2. Set permissions
                .authorizeHttpRequests(auth -> auth
                        // Allow these specific paths explicitly
                        .requestMatchers("/api/users/signup", "/api/users/login").permitAll()

                        // Block everything else
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}