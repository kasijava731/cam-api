package com.jvlcode.spring_boot_demo.controllers;

import java.util.Arrays;
import java.util.List;

import com.jvlcode.spring_boot_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.jvlcode.spring_boot_demo.entity.UserEntity;
import com.jvlcode.spring_boot_demo.exceptions.ResourceNotFoundException;
import com.jvlcode.spring_boot_demo.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
//	@Autowired
//	private UserRepository userRepository;

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, PasswordEncoder passen) {
        this.userRepository = userRepository;
        this.passwordEncoder = passen;
    }

    // ✅ GET (Get All Users)
	@GetMapping
	public List<UserEntity> getUsers() {
//		return Arrays.asList(new UserEntity(1L, "Logesh", "logesh@gmail.com"));
		return userRepository.findAll();

	}
	
	// ✅ POST (Create New User)
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    // ✅ GET (Get Single User)
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
//        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return userRepository.findById(id).orElseThrow();
    }

    // ✅ PUT (Update User by ID)
    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
    	UserEntity userData = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
//    	userData.setEmail(user.getEmail());
//    	userData.setName(user.getName());
        userData.merge(user);
    	return userRepository.save(userData);
    }

    // ✅ DELETE (Delete User by ID)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//    	UserEntity userData = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
//    	userRepository.delete(userData);
        userRepository.deleteById(id);
    	return ResponseEntity.ok().build();
    }
}
