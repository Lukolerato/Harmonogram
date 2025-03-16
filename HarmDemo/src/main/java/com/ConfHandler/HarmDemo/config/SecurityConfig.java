// package com.ConfHandler.HarmDemo.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/api/**").authenticated()  // Wymaga logowania dla /api/**
//                 .anyRequest().permitAll()  // Pozwól na dostęp do innych ścieżek
//             )
//             .formLogin(form -> form  // Zaktualizowana metoda formLogin z Customizer
//                 .permitAll()
//             )
//             .httpBasic(Customizer.withDefaults());  // Zaktualizowana konfiguracja Basic Auth
//     }
// }

package com.ConfHandler.HarmDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.withUsername("student")
                .password(passwordEncoder().encode("student")) // Użycie BCrypt do szyfrowania hasła
                .roles("USER")
                .build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").authenticated() // Wymaga logowania dla /api/**
                .anyRequest().permitAll() // Pozwól na dostęp do innych ścieżek
            )
            .formLogin(form -> form
                .loginPage("/login") // Strona logowania
                .permitAll()
            )
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
