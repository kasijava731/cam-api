package com.jvlcode.spring_boot_demo.services;

import com.jvlcode.spring_boot_demo.entity.OfUsersEntity;
import com.jvlcode.spring_boot_demo.repository.OfUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class OfCustomUserDetailsService implements UserDetailsService {
    @Autowired
    private OfUserRepository  ofUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OfUsersEntity ofuser=ofUserRepository.findByUsername(username);
        return new User(ofuser.getUsername(),ofuser.getPassword(), Collections.singleton(new SimpleGrantedAuthority("USER_ROLE")));
    }
}
