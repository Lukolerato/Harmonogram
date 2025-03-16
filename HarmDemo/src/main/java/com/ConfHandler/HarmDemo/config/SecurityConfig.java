package com.ConfHandler.HarmDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").authenticated()  // Wymaga logowania dla /api/**
                .anyRequest().permitAll()  // Pozwól na dostęp do innych ścieżek
            )
            .formLogin(form -> form  // Zaktualizowana metoda formLogin z Customizer
                .permitAll()
            )
            .httpBasic(Customizer.withDefaults());  // Zaktualizowana konfiguracja Basic Auth
    }
}
