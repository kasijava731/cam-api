package com.jvlcode.spring_boot_demo.controllers;
//package com.jvlcode.spring_boot_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class Homecontroller {

    @GetMapping("/home")
    public String home() {
        return "Login successful! Welcome to Spring Boot. My spring security just redirect into this because no other controller mapped to the security configuration class yet ";
    }
}