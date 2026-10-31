package com.jvlcode.spring_boot_demo.configurations;

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
//        return http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated()).build();
//       return http.authorizeHttpRequests(auth-> auth.requestMatchers("/api/users/**").permitAll().requestMatchers("home").permitAll()).build();
        return  http.authorizeHttpRequests(auth-> auth.requestMatchers("/api/users/**").authenticated().requestMatchers("home").permitAll()).formLogin(f->f.permitAll()).build();

    }
}
