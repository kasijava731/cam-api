package com.jvlcode.spring_boot_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvlcode.spring_boot_demo.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
	Optional<UserEntity> findByUsername(String username);
//	UserEntity findByUsername(String username); //we can set a globalException only when controller receives the exception
}
