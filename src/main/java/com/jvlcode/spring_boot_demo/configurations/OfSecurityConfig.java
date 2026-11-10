package com.jvlcode.spring_boot_demo.configurations;


import com.jvlcode.spring_boot_demo.services.CustomUserDetailsService;
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
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Profile("oauth")
public class OfSecurityConfig {

    @Bean
    public SecurityFilterChain OfSecurityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(h->h
                        .requestMatchers("/api/ofusers").permitAll()
//                        .requestMatchers("/api/ofusers/**").authenticated()
                        .anyRequest().permitAll())
                .formLogin(f->f.permitAll().defaultSuccessUrl("/dashboard"))
                .csrf(c->c.disable())
                .build();
    }

    @Bean
    public UserDetailsService ofUserDetailsService() {

        UserDetails user= User.withUsername("alice")
                .password("user123")
                .roles("user")
                .build();
        UserDetails admin= User.withUsername("zack")
                .password("admin123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user,admin);
//        return new OfCustomUserDetailsService();
    }




//    @Bean
//    public DaoAuthenticationProvider ofauthenticationProvider(){
//        DaoAuthenticationProvider authprovider=new DaoAuthenticationProvider();
//        authprovider.setUserDetailsService(ofUserDetailsService());
//        authprovider.setPasswordEncoder(passwordEncoder());
//        return authprovider;
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
