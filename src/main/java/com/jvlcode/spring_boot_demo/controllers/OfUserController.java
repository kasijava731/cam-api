package com.jvlcode.spring_boot_demo.controllers;

import com.jvlcode.spring_boot_demo.entity.OfUsersEntity;
import com.jvlcode.spring_boot_demo.repository.OfUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ofusers")
public class OfUserController {
    private OfUserRepository ofUserRepository;
    public OfUserController(OfUserRepository ofUserRepository) {
        this.ofUserRepository = ofUserRepository;
    }

    @GetMapping
    public List<OfUsersEntity> getAllOfUsers() {
       return ofUserRepository.findAll();
    }

    @PostMapping
    public OfUsersEntity saveOfUser(@RequestBody OfUsersEntity ofUsersEntity) {
        return ofUserRepository.save(ofUsersEntity);
    }
}
