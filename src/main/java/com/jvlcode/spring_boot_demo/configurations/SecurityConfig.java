package com.jvlcode.spring_boot_demo.configurations;

import com.jvlcode.spring_boot_demo.services.CustomUserDetailsService;
import com.jvlcode.spring_boot_demo.services.OfCustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Profile("default")
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated()).build();
//       return http.authorizeHttpRequests(auth-> auth.requestMatchers("/api/users/**").permitAll().requestMatchers("home").permitAll()).build();
        return  http.authorizeHttpRequests(auth-> auth
                        .requestMatchers(HttpMethod.POST,"/api/users").permitAll()
                        .requestMatchers("/api/users/**").authenticated()
//                        .requestMatchers("/").permitAll()
                        .anyRequest().permitAll())
                .formLogin(f->f.permitAll() .defaultSuccessUrl("/dashboard"))
                .csrf(c->c.disable())
                .build();

    }

    @Bean
    public UserDetailsService userDetailService( ){
//        UserDetails user= User.withUsername("alice")
//                .password(passen.encode("user123"))
//                .roles("user")
//                .build();
//        UserDetails admin= User.withUsername("zack")
//                .password(passen.encode("admin123"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user,admin);

        return  new CustomUserDetailsService();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authprovider = new DaoAuthenticationProvider();
        authprovider.setUserDetailsService(userDetailService());
        authprovider.setPasswordEncoder(passwordEncoder());
        return authprovider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
